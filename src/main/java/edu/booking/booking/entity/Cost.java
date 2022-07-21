package edu.booking.booking.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "cost")
public class Cost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clazz classId;
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Flight flightId;
    @JoinColumn(name = "passengers_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Passengers passengersId;

    public Cost() {
    }

    public Cost(Integer id) {
        this.id = id;
    }

    public Cost(Integer id, int quantity, BigDecimal amount) {
        this.id = id;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Clazz getClassId() {
        return classId;
    }

    public void setClassId(Clazz classId) {
        this.classId = classId;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public Passengers getPassengersId() {
        return passengersId;
    }

    public void setPassengersId(Passengers passengersId) {
        this.passengersId = passengersId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cost)) {
            return false;
        }
        Cost other = (Cost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Amount: ";
    }
}
