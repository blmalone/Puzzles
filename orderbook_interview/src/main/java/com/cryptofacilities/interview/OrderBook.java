package com.cryptofacilities.interview;

import java.util.List;

public class OrderBook {

    private String instrument;
    private OrderSide askSide = new OrderSide();
    private OrderSide bidSide = new OrderSide();

    public OrderBook(final String instrument) {
        this.instrument = instrument;
    }

    public void deleteOrder(final String orderId) {
        if(askSide.getOrderHashMap().containsKey(orderId)) {
            askSide.deleteOrder(orderId);
        } else {
            bidSide.deleteOrder(orderId);
        }
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(final String instrument) {
        this.instrument = instrument;
    }

    public OrderSide getAskSide() {
        return askSide;
    }

    public void setAskSide(final OrderSide askSide) {
        this.askSide = askSide;
    }

    public OrderSide getBidSide() {
        return bidSide;
    }

    public void setBidSide(final OrderSide bidSide) {
        this.bidSide = bidSide;
    }

    public long getTotalQuantityAtLevel(Side side, long priceLevel) {
        if (side.equals(Side.buy)) {
            return bidSide.getTradeableQuantityForLevel(priceLevel);
        } else {
            return askSide.getTradeableQuantityForLevel(priceLevel);
        }
    }

    public long getTotalVolumeAtLevel(Side side, long priceLevel) {
        if (side.equals(Side.buy)) {
            return bidSide.getTotalVolumeAtLevel(priceLevel);
        } else {
            return askSide.getTotalVolumeAtLevel(priceLevel);
        }
    }


    public List<Order> getOrdersAtLevel(final Side side, final Long priceLevel) {
        if (side.equals(Side.buy)) {
            return bidSide.getOrdersAtPriceLevel(priceLevel);
        } else {
            return askSide.getOrdersAtPriceLevel(priceLevel);
        }
    }

    public long getBestPriceForSide(final Side side) {
        if (side.equals(Side.buy)) {
            if (!bidSide.getPricesTree().isEmpty()) {
                return bidSide.getPricesTree().lastKey(); // Highest Bid Price is best
            }
            return 0;
        }
        if (!askSide.getPricesTree().isEmpty()) {
            return askSide.getPricesTree().firstKey(); // Lowest Ask Price is best
        }
        return 0;
    }
}
