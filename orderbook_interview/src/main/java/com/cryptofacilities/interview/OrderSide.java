package com.cryptofacilities.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * OrderSide will model the different sides of an OrderBook. Representing both Buyers (bids) and Sellers (asks).
 */
public class OrderSide {

    //Consists of a Price-Level (orders with same price are grouped together)
    private TreeMap<Long, LinkedList<Order>> pricesTree = new TreeMap<Long, LinkedList<Order>>();
    //Fast for Price exists operations and getPriceList O(1) - could cannot store duplicate keys
    private HashMap<Long, LinkedList<Order>> pricesHashMap = new HashMap<Long, LinkedList<Order>>();
    //Fast for contains operations O(1) -
    private HashMap<String, Order> orderHashMap = new HashMap<String, Order>();

    private long numberOfOrdersOnSide;
    private long tradeableQuantityOnSide;
    private long totalVolumeOnSide;

    public OrderSide() {
        //Do i care about the ordering of the orders in a level in the asksTree? Why? Because I'll not be retrieving
        //them from that structure. I just want to ensure that th contents of the two structures are kept consistent.
        pricesTree.clear();
        pricesHashMap.clear();
        orderHashMap.clear();
        numberOfOrdersOnSide = 0;
        tradeableQuantityOnSide = 0;
        totalVolumeOnSide = 0;
    }

    public void addNewOrder(final Order order) {
        String orderId = order.getOrderId();
        if(!orderHashMap.containsKey(orderId)) { //If order doesn't exist then add it.
            Long priceLevel = order.getPrice();
            if(!pricesHashMap.containsKey(priceLevel)) { //Adding a new price level to PriceTree.
                LinkedList<Order> newOrdersList = new LinkedList<Order>();
                newOrdersList.add(order);
                pricesTree.put(priceLevel, newOrdersList); //Fast retrieval of best bid and ask prices.
                pricesHashMap.put(priceLevel, newOrdersList); // Fast retrieval of prices operations
                orderHashMap.put(orderId, order); // Fast order operations
            } else {
                //Add the order now at the given price level
                orderHashMap.put(orderId, order);
                LinkedList<Order> orders = pricesHashMap.get(priceLevel);
                orders.addLast(order);
                pricesHashMap.put(priceLevel, orders);
            }
            numberOfOrdersOnSide++;
            tradeableQuantityOnSide =+ order.getQuantity();
            totalVolumeOnSide = totalVolumeOnSide + (priceLevel * order.getQuantity());
        }
    }

    public void deleteOrder(final String orderId) {
        final Order orderToDelete = orderHashMap.get(orderId);
        if (orderToDelete != null) {
            long quantity = orderToDelete.getQuantity();
            long priceLevel = orderToDelete.getPrice();
            numberOfOrdersOnSide--;
            tradeableQuantityOnSide -= quantity;
            long orderVolume =  priceLevel * quantity;
            totalVolumeOnSide -= orderVolume;
            pricesTree.get(priceLevel).remove(orderToDelete); //Does this remove the actual object?
            pricesHashMap.get(priceLevel).remove(orderToDelete);
            if (pricesHashMap.get(priceLevel).size() == 0) {
                pricesTree.remove(priceLevel);
                pricesHashMap.remove(priceLevel);
            }
            orderHashMap.remove(orderId);
        }
    }

    public TreeMap<Long, LinkedList<Order>> getPricesTree() {
        return pricesTree;
    }

    public void setPricesTree(final TreeMap<Long, LinkedList<Order>> pricesTree) {
        this.pricesTree = pricesTree;
    }

    public HashMap<Long, LinkedList<Order>> getPricesHashMap() {
        return pricesHashMap;
    }

    public void setPricesHashMap(final HashMap<Long, LinkedList<Order>> pricesHashMap) {
        this.pricesHashMap = pricesHashMap;
    }

    public HashMap<String, Order> getOrderHashMap() {
        return orderHashMap;
    }

    public void setOrderHashMap(final HashMap<String, Order> orderHashMap) {
        this.orderHashMap = orderHashMap;
    }

    public long getNumberOfOrdersOnSide() {
        return numberOfOrdersOnSide;
    }

    public void setNumberOfOrdersOnSide(final int numberOfOrdersOnSide) {
        this.numberOfOrdersOnSide = numberOfOrdersOnSide;
    }

    public long getTradeableQuantityOnSide() {
        return tradeableQuantityOnSide;
    }

    public void setTradeableQuantityOnSide(final long tradeableQuantityOnSide) {
        this.tradeableQuantityOnSide = tradeableQuantityOnSide;
    }

    public long getTotalVolumeOnSide() {
        return totalVolumeOnSide;
    }

    public void setTotalVolumeOnSide(final long totalVolumeOnSide) {
        this.totalVolumeOnSide = totalVolumeOnSide;
    }

    public long getTradeableQuantityForLevel(final long priceLevel) {
        long result = 0;
        for (Order order : pricesHashMap.get(priceLevel)) {
            result += order.getQuantity();
        }
        return result;
    }

    public LinkedList<Order> getOrdersAtPriceLevel(final Long priceLevel) {
        return pricesHashMap.get(priceLevel);
    }

    public long getTotalVolumeAtLevel(final long priceLevel) {
        long totalVolume = 0;
        for (Order order : pricesHashMap.get(priceLevel)) {
            totalVolume = totalVolume + (priceLevel * order.getQuantity());
        }
        return totalVolume;
    }
}
