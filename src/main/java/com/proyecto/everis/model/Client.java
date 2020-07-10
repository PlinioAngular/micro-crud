package com.proyecto.everis.model;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection ="client" )
public class Client {
	
		@Id
         private String id;
         
         private String typeDoc;

         private String nameClient;
         
         private String numDoc;
         
         private String typeClient;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTypeDoc() {
			return typeDoc;
		}

		public void setTypeDoc(String typeDoc) {
			this.typeDoc = typeDoc;
		}

		public String getNameClient() {
			return nameClient;
		}

		public void setNameClient(String nameClient) {
			this.nameClient = nameClient;
		}

		public String getNumDoc() {
			return numDoc;
		}

		public void setNumDoc(String numDoc) {
			this.numDoc = numDoc;
		}

		public String getTypeClient() {
			return typeClient;
		}

		public void setTypeClient(String typeClient) {
			this.typeClient = typeClient;
		}

		
}
