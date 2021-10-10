/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gladioustennisapp;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author salga
 */
@Entity
@Table(name = "payment", catalog = "tennis", schema = "")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByPaymentid", query = "SELECT p FROM Payment p WHERE p.paymentid = :paymentid")
    , @NamedQuery(name = "Payment.findByStudentid", query = "SELECT p FROM Payment p WHERE p.studentid = :studentid")
    , @NamedQuery(name = "Payment.findByDate", query = "SELECT p FROM Payment p WHERE p.date = :date")
    , @NamedQuery(name = "Payment.findByTotalamount", query = "SELECT p FROM Payment p WHERE p.totalamount = :totalamount")
    , @NamedQuery(name = "Payment.findByPaid", query = "SELECT p FROM Payment p WHERE p.paid = :paid")})
public class Payment implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentid")
    private Integer paymentid;
    @Basic(optional = false)
    @Column(name = "studentid")
    private int studentid;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "totalamount")
    private long totalamount;
    @Basic(optional = false)
    @Column(name = "paid?")
    private short paid;

    public Payment() {
    }

    public Payment(Integer paymentid) {
        this.paymentid = paymentid;
    }

    public Payment(Integer paymentid, int studentid, Date date, long totalamount, short paid) {
        this.paymentid = paymentid;
        this.studentid = studentid;
        this.date = date;
        this.totalamount = totalamount;
        this.paid = paid;
    }

    public Integer getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Integer paymentid) {
        Integer oldPaymentid = this.paymentid;
        this.paymentid = paymentid;
        changeSupport.firePropertyChange("paymentid", oldPaymentid, paymentid);
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        int oldStudentid = this.studentid;
        this.studentid = studentid;
        changeSupport.firePropertyChange("studentid", oldStudentid, studentid);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public long getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(long totalamount) {
        long oldTotalamount = this.totalamount;
        this.totalamount = totalamount;
        changeSupport.firePropertyChange("totalamount", oldTotalamount, totalamount);
    }

    public short getPaid() {
        return paid;
    }

    public void setPaid(short paid) {
        short oldPaid = this.paid;
        this.paid = paid;
        changeSupport.firePropertyChange("paid", oldPaid, paid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentid != null ? paymentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentid == null && other.paymentid != null) || (this.paymentid != null && !this.paymentid.equals(other.paymentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gladioustennisapp.Payment[ paymentid=" + paymentid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
