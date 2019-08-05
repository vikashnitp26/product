package com.product.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Cart")
@Component
public class CartItem implements Serializable {

 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2148379415619933775L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private int KartItemid;
	
        private int quantity=1;
        private double total;
        private String pId;
        private int u_id;



        public CartItem() {

        }       


		public CartItem(int quantity, String pId,int userid) {
			super();
			this.quantity = quantity;
			this.pId = pId;
			this.u_id = userid;
		}



		public int getKartItemid() {
			return KartItemid;
		}



		public void setKartItemid(int kartItemid) {
			KartItemid = kartItemid;
		}



		public int getQuantity() {
			return quantity;
		}



		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}



		public double getTotal() {
			return total;
		}



		public void setTotal(double total) {
			this.total = total;
		}


		@Override
		public String toString() {
			return "CartItem [KartItemid=" + KartItemid + ", quantity=" + quantity + ", total=" + total + ", pId=" + pId
					+ ", u_id=" + u_id + "]";
		}


		public String getpId() {
			return pId;
		}


		public void setpId(String pId) {
			this.pId = pId;
		}


		public int getU_id() {
			return u_id;
		}


		public void setU_id(int u_id) {
			this.u_id = u_id;
		}

       
        
}
