package application;

import java.awt.event.FocusEvent;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class MyController {

	@FXML
	private Button borrar;
	@FXML
	private Button grabar;
	@FXML
	private TextField nombre;
	@FXML
	private TextField apellido1;
	@FXML
	private TextField apellido2;
	@FXML
	private TextField email;
	
    public void initialize() {

    }
    
    public void Borrar(ActionEvent event) {
        
 	     Alert alert = new Alert (Alert.AlertType.ERROR);
 	     alert.setTitle("Borrar");
 		 alert.setHeaderText(null);
 		 alert.setContentText("Los campos se han borrado.");
 		 alert.showAndWait();
 	   
		 this.nombre.setText("");
		 this.apellido1.setText("");
		 this.apellido2.setText("");
		 this.email.setText("");
 	   
    }
    
    public void Grabar(ActionEvent event){
    
    	if (this.nombre.getLength()==0 || this.apellido1.getLength()==0 || this.apellido2.getLength()==0 || this.email.getLength()==0){
    	     Alert alert = new Alert (Alert.AlertType.ERROR);
     	     alert.setTitle("Campos vacios");
     		 alert.setHeaderText(null);
     		 alert.setContentText("Algun campo no ha sido rellenado.");
     		 alert.showAndWait();
    	}else {
    		String nombre = this.nombre.getText();
    		String apellido1 = this.apellido1.getText();
    		String apellido2 = this.apellido2.getText();
    		String email = this.email.getText();
    		boolean erNombre = false;
    		boolean erApellido1 = false;
    		boolean erApellido2 = false;
    		boolean emailcorrecto = false;
    		
    		for (int i=0;i<nombre.length();i++){
    			if(nombre.charAt(i)<'a' || nombre.charAt(i)>'z'){		
    				erNombre = true;
    			}
    		}
    		for (int i=0;i<apellido1.length();i++){
    			if(apellido1.charAt(i)<'a' || apellido1.charAt(i)>'z'){		
    				erApellido1 = true;
    			}
    		}
    		for (int i=0;i<apellido2.length();i++){
    			if(apellido2.charAt(i)<'a' || apellido2.charAt(i)>'z'){		
    				erApellido2 = true;
    			}
    		}
    		if (erNombre==true){
    	 	     Alert alert = new Alert (Alert.AlertType.ERROR);
    	 	     alert.setTitle("Nombre incorrecto.");
    	 		 alert.setHeaderText(null);
    	 		 alert.setContentText("El nombre tiene caracteres incorrectos.");
    	 		 alert.showAndWait();
    		     }
    		if (erApellido1==true){
   	 	         Alert alert = new Alert (Alert.AlertType.ERROR);
   	 	         alert.setTitle("Apellido1 incorrecto.");
   	 		     alert.setHeaderText(null);
   	 		     alert.setContentText("El apellido1 tiene caracteres incorrectos.");
   	 		     alert.showAndWait();
   		         }
    		if (erApellido2==true){
      	 	     Alert alert = new Alert (Alert.AlertType.ERROR);
      	 	     alert.setTitle("Apellido2 incorrecto.");
      	 		 alert.setHeaderText(null);
      	 		 alert.setContentText("El apellido2 tiene caracteres incorrectos.");
      	 		 alert.showAndWait();
      		     }
    		if (apellido1.equals(apellido2)){
  	 	         Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
  	 	         alert.setTitle("APELLIDOS IGUALES");
  	 		     alert.setHeaderText(null);
  	 		     alert.setContentText("Los apellidos son iguales ¿es correcto?.");
  	 		     
  	 		     ButtonType si = new ButtonType ("Si", ButtonData.CANCEL_CLOSE);
  	 		     ButtonType no = new ButtonType ("No");
  	 		     
  	 		     alert.getButtonTypes().setAll(si,no);
  	 		     
  	 		     Optional<ButtonType> resultado = alert.showAndWait();
  	 		     
  	 		     if (resultado.get()==no){
  	 		    	 this.apellido1.setText("");
  	 		    	 this.apellido2.setText("");
  	 		     }else {
					
				}
    		}
    		for (int i=0;i<email.length();i++){
    			if(email.charAt(i)=='@' && (email.substring(email.length()-4)==".com" || email.substring(email.length()-3)==".es")){
    				emailcorrecto = true;
    			}
    		}
    		if (erNombre==false && erApellido1==false && erApellido1==false && emailcorrecto==true){
 	 	         Alert alert = new Alert (Alert.AlertType.INFORMATION);
 	 	         alert.setTitle("CAMPOS CORRECTOS");
 	 		     alert.setHeaderText(null);
 	 		     alert.setContentText("Los datos se van a almacenar.");
    		}
		}
    	
    	
    }
}
