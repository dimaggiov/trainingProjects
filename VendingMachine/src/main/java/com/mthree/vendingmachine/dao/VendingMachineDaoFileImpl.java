package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.VendingMachineItem;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class VendingMachineDaoFileImpl implements VendingMachineDao{

    private final String INVENTORY_FILE;
    public static final String DELIMITER = "::";

    private Map<Integer, VendingMachineItem> items = new HashMap<>();


    public VendingMachineDaoFileImpl() {
        this.INVENTORY_FILE = "inventory.txt";
    }

    public VendingMachineDaoFileImpl(String INVENTORY_FILE) {
        this.INVENTORY_FILE = INVENTORY_FILE;
    }

    @Override
    public VendingMachineItem sellItem(int itemID) throws VendingMachinePersistenceException {
        loadFile();
        VendingMachineItem soldItem = items.get(itemID);
        if(soldItem == null)
            return null;

        items.get(itemID).sell();

        saveFile();
        return soldItem;
    }

    @Override
    public VendingMachineItem getItem(int itemID) throws VendingMachinePersistenceException {
        loadFile();
        return items.get(itemID);
    }

    @Override
    public List<VendingMachineItem> getAllItems() throws VendingMachinePersistenceException {
        loadFile();
        return new ArrayList<>(items.values());
    }

    @Override
    public List<VendingMachineItem> getAllSellableItems() throws VendingMachinePersistenceException {
        loadFile();
        return items.values().stream()
                .filter((item) -> item.getStock() > 0)
                .collect(Collectors.toList());
    }

    private void loadFile() throws VendingMachinePersistenceException{
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load inventory data into memory.", e);
        }

        String currentLine;
        VendingMachineItem currentItem;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentItem = unmarshallItem(currentLine);
            items.put(currentItem.getId(), currentItem);
        }

        scanner.close();
    }


    private void saveFile() throws VendingMachinePersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save student data.", e);
        }


        String inventoryItemAsText;
        List<VendingMachineItem> itemList = this.getAllItems();
        for (VendingMachineItem currentItem : itemList) {
            inventoryItemAsText = marshallItem(currentItem);
            out.println(inventoryItemAsText);
            out.flush();
        }

        out.close();
    }

    private String marshallItem(VendingMachineItem currentItem) {
        String inventoryItemAsText = currentItem.getId() + DELIMITER;
        inventoryItemAsText += currentItem.getStock() + DELIMITER;
        inventoryItemAsText += currentItem.getPrice() + DELIMITER;
        inventoryItemAsText += currentItem.getItemName() + DELIMITER;

        return inventoryItemAsText;
    }

    private VendingMachineItem unmarshallItem(String currentLine) {
        String[] itemTokens = currentLine.split(DELIMITER);
        int itemId =  Integer.parseInt(itemTokens[0]);
        VendingMachineItem studentFromFile = new VendingMachineItem(itemId);
        studentFromFile.setStock(Integer.parseInt(itemTokens[1]));
        studentFromFile.setPrice( new BigDecimal(itemTokens[2]));
        studentFromFile.setItemName(itemTokens[3]);

        return studentFromFile;

    }
}


