package edu.booking.booking.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "departureAirport")
    private String from;
    @Basic(optional = false)
    @Column(name = "arrivalAirport")
    private String to;
    @Basic(optional = false)
    @Column(name = "departureDate")
    @Temporal(TemporalType.DATE)
    private Date dateOfFlight;
    @JoinColumn(name = "user_creator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userCreatorId;
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flightId")
    private List<Cost> costList;

    public Flight() {
    }

    public Flight(Integer id) {
        this.id = id;
    }

    public Flight(Integer id, String from, String to, Date dateOfFlight) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.dateOfFlight = dateOfFlight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public User getUserCreatorId() {
        return userCreatorId;
    }

    public void setUserCreatorId(User userCreatorId) {
        this.userCreatorId = userCreatorId;
    }

    public List<Cost> getCostList() {
        return costList;
    }

    public void setCostList(List<Cost> costList) {
        this.costList = costList;
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
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return from + " " + to;
    }
}
