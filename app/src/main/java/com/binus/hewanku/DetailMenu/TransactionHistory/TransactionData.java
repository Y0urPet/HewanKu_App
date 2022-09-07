package com.binus.hewanku.DetailMenu.TransactionHistory;

import java.util.ArrayList;

public class TransactionData implements TransactionHistory{

    public static ArrayList<Transaction> getListData() {
        ArrayList<Transaction> list = new ArrayList<>();
        for (int position = 0; position < activityName.size(); position++) {
            Transaction transaction = new Transaction();
            transaction.setStatus(activityName.get(position));
            transaction.setAnimalType(animalTypes.get(position));
            transaction.setAnimalName(animalNames.get(position));
            transaction.setDate(dates.get(position));
            transaction.setTime(times.get(position));
            transaction.setPetshopLocation(petshopLocations.get(position));
            transaction.setPaymentMethod(paymentMethods.get(position));
            transaction.setId(ids.get(position));
            list.add(transaction);
        }
        return list;
    }
}
