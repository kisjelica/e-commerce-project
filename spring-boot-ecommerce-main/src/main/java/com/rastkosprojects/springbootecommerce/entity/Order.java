/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Class that represents an Order.
 *
 * @author rastko
 */
@Entity
@Table(name = "orders")
public class Order {

    /**
     * Attribute - Id primary key as Long.
	 *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Attribute - order tracking number as String.
	 *
     */
    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;
    /**
     * Attribute - total quantity as integer.
	 *
     */
    @Column(name = "total_quantity")
    private int totalQuantity;
    /**
     * Attribute - total price as BigDecimal.
	 *
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    /**
     * Attribute - order status as boolean.
	 *
     */
    @Column(name = "status")
    private String status;
    /**
     * Attribute - date and time of order creation as Date.
	 *
     */
    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;

    /**
     * Attribute - date and time of order update as Date.
	 *
     */
    @UpdateTimestamp
    @Column(name = "last_updated")
    private Date lastUpdated;
    /**
     * Attribute - order items as HashSet of OrderItem objects.
	 *
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();
    /**
     * Attribute - customer as Customer object.
	 *
     */
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    /**
     * Attribute - shipping address as Address object.
	 *
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
    /**
     * Attribute - billing address as Address object.
	 *
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;

    public Long getId() {
        return id;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    /**
     * Sets order tracking number attribute to new value.
     *
     * @param orderTrackingNumber order tracking number as String
     * @throws java.lang.NullPointerException if argument is null
     * @throws java.lang.RuntimeException if argument is not 36 characters long.
	 *
     */
    public void setOrderTrackingNumber(String orderTrackingNumber) {
        if (orderTrackingNumber == null) {
            throw new NullPointerException("Order tracking number cannot be null.");
        }
        if (orderTrackingNumber.length() != 36) {
            throw new RuntimeException("Order tracking number must be a 36 character UUID");
        }
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * Sets total quantity attribute to new value.
     *
     * @param totalQuantity total order quantity as integer
     *
     * @throws java.lang.RuntimeException if quantity is zero or less.
	 *
     */
    public void setTotalQuantity(int totalQuantity) {
        if (totalQuantity <= 0) {
            throw new RuntimeException("Total quantity cannot be zero.");
        }
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets total price attribute to new value.
     *
     * @param totalPrice total order price as BigDecimal
     *
     * @throws java.lang.RuntimeException if price is zero.
	 *
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        if (totalPrice.equals(BigDecimal.ZERO)) {
            throw new RuntimeException("Total price cannot be zero");
        }
        this.totalPrice = totalPrice;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    /**
     * Sets order items attribute to new value.
     *
     * @param orderItems order items as Set of OrderItem objects
     * @throws java.lang.NullPointerException if argument is null
     * @throws java.lang.RuntimeException if set is empty
	 *
     */
    public void setOrderItems(Set<OrderItem> orderItems) {
        if (orderItems == null) {
            throw new NullPointerException("Order items cannot be null");
        }
        if (orderItems.isEmpty()) {
            throw new RuntimeException("Order items cannot be empty");
        }
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets customer attribute to new value.
     *
     * @param customer customer as Customer object
     * @throws java.lang.NullPointerException if argument is null
	 *
     */
    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new NullPointerException("Customer cannot be null");
        }
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets shipping address attribute to new value.
     *
     * @param shippingAddress shipping address as Address object
     * @throws java.lang.NullPointerException if argument is null
	 *
     */
    public void setShippingAddress(Address shippingAddress) {
        if (shippingAddress == null) {
            throw new NullPointerException("Shipping address cannot be null");
        }
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Sets billing address attribute to new value.
     *
     * @param billingAddress shipping address as Address object
     * @throws java.lang.NullPointerException if argument is null
	 *
     */
    public void setBillingAddress(Address billingAddress) {
        if (billingAddress == null) {
            throw new NullPointerException("Billing address cannot be null");
        }
        this.billingAddress = billingAddress;
    }

    /**
     * Method to add order items to Order. If orderItems is null, a new HashSet
     * is instantiated.
     *
     * @param item order items as OrderItem object
     * @throws java.lang.NullPointerException if argument is null
	 *
     */
    public void add(OrderItem item) {
        if (item != null) {
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        } else {
            throw new NullPointerException("Null items cannot be added to order!");
        }
    }

    /**
     * @return result Returns hashCode result.
	 *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderTrackingNumber == null) ? 0 : orderTrackingNumber.hashCode());
        return result;
    }

    /**
     * Compares order tracking number attribute of the argument to this object.
     *
     * @return true if objects are equal
     * @return false if objects are not equal
     *
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Order other = (Order) obj;
        if (orderTrackingNumber == null) {
            if (other.orderTrackingNumber != null) {
                return false;
            }
        } else if (!orderTrackingNumber.equals(other.orderTrackingNumber)) {
            return false;
        }
        return true;
    }

}
