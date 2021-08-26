package com.doan2.spring.entity.supportentity;

import com.doan2.spring.entity.Product;
import com.doan2.spring.entity.ShippingCompany;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class OrderProductShopkeeper {
    private int idOrder;
    private List<Product> productList;
    private BigDecimal totalMoney;
    private String vnTotalMoney;
    private String paymentOption;
    private String status;
    private ShippingCompany shippingCompany;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderProductShopkeeper))
            return false;

        OrderProductShopkeeper mdc = (OrderProductShopkeeper) obj;
        return mdc.idOrder == idOrder;


    }

    public String getVnTotalMoney() {
        return vnTotalMoney;
    }

    public void setVnTotalMoney(String vnTotalMoney) {
        this.vnTotalMoney = vnTotalMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, productList, totalMoney, paymentOption, status, shippingCompany);
    }

    public OrderProductShopkeeper() {
    }

    public OrderProductShopkeeper(int idOrder, List<Product> productList, BigDecimal totalMoney, String paymentOption, String status, ShippingCompany shippingCompany) {
        this.idOrder = idOrder;
        this.productList = productList;
        this.totalMoney = totalMoney;
        this.paymentOption = paymentOption;
        this.status = status;
        this.shippingCompany = shippingCompany;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShippingCompany getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(ShippingCompany shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    @Override
    public String toString() {
        return "OrderProductShopkeeper{" +
                "idOrder=" + idOrder +
                ", productList=" + productList +
                ", totalMoney=" + totalMoney +
                ", paymentOption='" + paymentOption + '\'' +
                ", status='" + status + '\'' +
                ", shippingCompany=" + shippingCompany +
                '}';
    }
}
