package first;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddUsers extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	GridPane grid;
	TextField txtUid,txtPwd,txtMno;
	Button btnNew,btnAdd,btnDel,btnUpd,btnSrch;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		grid = new GridPane();
		grid.setGridLinesVisible(false);
		grid.setHgap(20);
		grid.setVgap(20);
		grid.setAlignment(Pos.CENTER);
		
		Circle cir = new Circle(60,60,30);
		//ImageView logo = new ImageView(new Image(AddUsers.class.getResourceAsStream("google.jpg")));
		Image img = new Image(AddUsers.class.getResourceAsStream("google.jpg"));
		cir.setFill(new ImagePattern(img));
		
		Text lblTitle,lblUid,lblPwd,lblMno;
		lblTitle = new Text("Add Users");
		lblTitle.setUnderline(true);
		lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		
		HBox hboxTitle= new HBox();
		hboxTitle.setAlignment(Pos.CENTER);
		HBox.setMargin(lblTitle, new Insets(0,0,0,30));
		hboxTitle.getChildren().add(lblTitle);
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(cir,lblTitle);
		hbox1.setAlignment(Pos.CENTER);
		//GridPane.setConstraints(hbox1, 0, 0, 3, 1, HPos.CENTER, VPos.CENTER, null, null, null);
		
		//-----------------------------------------------
		
		lblUid = new Text("User Id");
		lblPwd = new Text("Password");
		lblMno = new Text("Mobile no.");
		
		GridPane.setConstraints(lblUid, 0, 1, 1, 1, HPos.CENTER, VPos.CENTER, null, null, null);
		GridPane.setConstraints(lblPwd, 0, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, null);
		GridPane.setConstraints(lblMno, 0, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, null);
		
		txtUid = new TextField();
		txtUid.setPadding(new Insets(5));
		txtUid.setPromptText("Enter User Id");
		
		txtPwd = new TextField();
		txtPwd.setPadding(new Insets(5));
		txtPwd.setPromptText("Enter Password");
		
		txtMno = new TextField();
		txtMno.setPadding(new Insets(5));
		txtMno.setPromptText("Enter Mobile No.");
		
		//------------Adding Buttons-----------------
		
		btnSrch = new Button("Search");
		btnSrch.setPrefSize(70, 20);
		btnSrch.setAlignment(Pos.CENTER);
		
		btnNew = new Button("New");
		btnNew.setPrefSize(70, 20);
		btnNew.setAlignment(Pos.CENTER);
		
		btnAdd = new Button("Add");
		btnAdd.setPrefSize(70, 20);
		btnAdd.setAlignment(Pos.CENTER);
		
		btnDel = new Button("Delete");
		btnDel.setPrefSize(70, 20);
		btnDel.setAlignment(Pos.CENTER);
		
		btnUpd = new Button("Update");
		btnUpd.setPrefSize(70, 20);
		btnUpd.setAlignment(Pos.CENTER);
		
		HBox hboxBtns = new HBox();
		hboxBtns.setSpacing(20);
		hboxBtns.getChildren().addAll(btnNew,btnAdd,btnDel,btnUpd);
		
		grid.add(hbox1,0,0,3,1);
		grid.getChildren().addAll(lblUid,lblPwd,lblMno);
		grid.add(txtUid, 1, 1);
		grid.add(txtPwd, 1, 2);
		grid.add(txtMno, 1, 3);
		grid.add(btnSrch, 2, 1);
		grid.add(hboxBtns, 0, 4, 3, 1);
		
		//==================EVENTS========================
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(txtUid.getText().isEmpty()){
					txtUid.setStyle("-fx-border-color:red");
				}
				if(txtPwd.getText().isEmpty()){
					txtPwd.setStyle("-fx-border-color:red");
				}
				if(txtMno.getText().isEmpty()){
					txtMno.setStyle("-fx-border-color:red");
				}
			}
		});
		
		Scene scene = new Scene(grid, 400,300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}