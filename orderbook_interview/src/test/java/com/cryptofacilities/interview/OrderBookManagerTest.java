package com.cryptofacilities.interview;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderBookManagerTest {

    @Test
    public void testAddOrderWithZeroQuantityOrder() {
        OrderBookManagerImpl orderBookManager = new OrderBookManagerImpl();
        String instrument = "BTC";
        long priceLevel = 100;
        Order zeroQuantityOrder = new Order("uniqueID", instrument, Side.buy, priceLevel, 0);
        orderBookManager.addOrder(zeroQuantityOrder);
        assertNull(orderBookManager.getOrdersAtLevel(instrument, Side.buy, priceLevel));
    }

    @Test
    public void testAddOrderWithNonZeroQuantityOrder() {
        OrderBookManagerImpl orderBookManager = new OrderBookManagerImpl();
        String instrument = "BTC";
        long priceLevel = 100;
        Order nonZeroQuantityOrder = new Order("uniqueID", instrument, Side.buy, priceLevel, 10);
        orderBookManager.addOrder(nonZeroQuantityOrder);
        assertTrue(orderBookManager.getOrdersAtLevel(instrument, Side.buy, priceLevel).size() == 1);
    }

    @Test
    public void testAddOrderWithNonExistentInstrument() {
        OrderBookManagerImpl orderBookManager = new OrderBookManagerImpl();
        String instrument = "ETH";
        long priceLevel = 100;
        Order order = new Order("uniqueID", instrument, Side.buy, priceLevel, 10);
        orderBookManager.addOrder(order);
        assertNull(orderBookManager.getOrdersAtLevel(instrument, Side.buy, priceLevel));
    }

    @Test
    public void testAddOrderAndGetAllOrdersAtLevelInOrder() {
        OrderBookManagerImpl orderBookManager = new OrderBookManagerImpl();
        String instrument = "BTC";
        long priceLevel = 100;
        Order order = new Order("uniqueID", instrument, Side.buy, priceLevel, 10);
        Order order1 = new Order("uniqueID1", instrument, Side.buy, priceLevel, 10);
        Order order2 = new Order("uniqueID2", instrument, Side.buy, priceLevel, 10);
        Order order3 = new Order("uniqueID3", instrument, Side.buy, priceLevel, 10);
        orderBookManager.addOrder(order);
        orderBookManager.addOrder(order1);
        orderBookManager.addOrder(order2);
        orderBookManager.addOrder(order3);

        final List<Order> ordersAtLevel = orderBookManager.getOrdersAtLevel(instrument, Side.buy, priceLevel);
        assertTrue(ordersAtLevel.get(0).equals(order));
        assertTrue(ordersAtLevel.get(1).equals(order1));
        assertTrue(ordersAtLevel.get(2).equals(order2));
        assertTrue(ordersAtLevel.get(3).equals(order3));
    }

    @Test
    public void testAddOrderWithNullOrder() {
        OrderBookManagerImpl orderBookManager = new OrderBookManagerImpl();
        String instrument = "BTC";
        orderBookManager.addOrder(null);
        assertTrue(orderBookManager.getBestPrice(instrument, Side.buy) == 0);
        assertTrue(orderBookManager.getBestPrice(instrument, Side.sell) == 0);
    }

    @Test
    public void testDeleteOrderSuccess() {
        OrderBookManagerImpl orderBookManager = new OrderBookManagerImpl();
        String instrument = "BTC";
        long priceLevel = 100;
        String id = "uniqueID";
        Order order = new Order(id, instrument, Side.buy, priceLevel, 10);
        orderBookManager.addOrder(order);
        assertTrue(orderBookManager.getOrderNumAtLevel(instrument, Side.buy, priceLevel) == 1);
        orderBookManager.deleteOrder(id);
        assertTrue(orderBookManager.getOrderNumAtLevel(instrument, Side.buy, priceLevel) == 0);
    }
}
