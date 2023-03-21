package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartupPage extends Application {

	String enteredUserName;
	String hist[] = new String[5];

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane root = new BorderPane();
		GridPane gridtop = new GridPane();
		gridtop.setVgap(10);
		gridtop.setHgap(10);
		VBox properties = new VBox();
		HBox bottom = new HBox();
		HBox homepg_btns = new HBox(10);
		homepg_btns.setAlignment(Pos.BOTTOM_CENTER);
		GridPane.setConstraints(homepg_btns, 30, 2, 1, 1);
//		bottom.setSpacing(30);
		bottom.setPadding(new Insets(0, 0, 20, 0));
		bottom.setAlignment(Pos.CENTER);
		properties.setSpacing(30);
		properties.setPadding(new Insets(0, 80, 0, 0));
		properties.setAlignment(Pos.CENTER_LEFT);

		Scene scene1 = new Scene(root, 800, 500);
		stage.setTitle("HomePage");
		stage.setFullScreen(true);

		// Creating buttons
		Button login = new Button("Login");
		login.setFont(Font.font("", FontWeight.BOLD, 14));
		login.setMinWidth(100);
		login.setMinHeight(40);
//		GridPane.setConstraints(login, 50, 3, 1, 1);
		Button signup = new Button("Sign up");
		signup.setFont(Font.font("", FontWeight.BOLD, 14));
		signup.setMinWidth(100);
		signup.setMinHeight(40);
//		GridPane.setConstraints(signup, 51, 3, 1, 1);

		// Adding logo
		Image image = new Image("FinCorp.png");
		ImageView logo = new ImageView(image);
		ImageView logo2 = new ImageView(image);
		// DropShadow effect
		DropShadow dropShadow_home = new DropShadow();
		dropShadow_home.setOffsetX(5);
		dropShadow_home.setOffsetY(5);
		logo2.setEffect(dropShadow_home);
		logo.setEffect(dropShadow_home);
		logo2.setFitWidth(654);
		logo2.setFitHeight(250);
		GridPane.setConstraints(logo2, 1, 1, 2, 2);

		// Adding Central Image
		Image image2 = new Image("banks-ads.png");
		ImageView cntrimg = new ImageView(image2);
		cntrimg.setFitHeight(350);
		cntrimg.setFitWidth(700);

		// Adding Bank properties
		Text txt1 = new Text("	» Faster Transactions");
		txt1.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 40));
		txt1.setFill(Color.DARKBLUE);
		Text txt2 = new Text("	» Enhanced Securities  ");
		txt2.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 40));
		txt2.setFill(Color.DARKGREEN);
		Text txt3 = new Text("	» Multiple Payment Options");
		txt3.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 40));
		txt3.setFill(Color.DARKBLUE);
		Text txt4 = new Text("	» Trustable Gateway");
		txt4.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 40));
		txt4.setFill(Color.DARKGREEN);
		Text txt5 = new Text("	» Easy to use Interface");
		txt5.setFont(Font.font("Berlin Sans FB", FontWeight.NORMAL, 40));
		txt5.setFill(Color.DARKBLUE);
		Text cpyrgt = new Text("© Copyright");
		cpyrgt.setFont(Font.font("Ariel", FontWeight.NORMAL, 20));

		// Creating Back Buttons
		Button btnBack_home = new Button("Back");
		Button btnBack_home2 = new Button("Back");

		// Setting Ids
		cntrimg.setId("image");
		root.setId("bp");
		gridtop.setId("root");
		login.setId("btnLogin");
		signup.setId("btnLogin");

		// Inserting into layouts
		root.setTop(gridtop);
		root.setRight(properties);
		root.setBottom(bottom);
		root.setCenter(cntrimg);
		homepg_btns.getChildren().addAll(login, signup);
		gridtop.getChildren().addAll(logo2, homepg_btns);
		properties.getChildren().addAll(txt1, txt2, txt3, txt4, txt5);
		bottom.getChildren().addAll(cpyrgt);

		// login portal code start
		// *****************************************************************************
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb = new HBox();
		hb.setPadding(new Insets(20, 20, 20, 30));
		HBox hblogin = new HBox(10);

		// Adding GridPane
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(20, 20, 20, 20));
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.setAlignment(Pos.CENTER);

		// Implementing Nodes for GridPane
		Label lblUserName = new Label("Username");
		final TextField txtUserName = new TextField();
		Label lblPassword = new Label("Password");
		final PasswordField pf = new PasswordField();
		Button btnLogin = new Button("Login");
		final Label lblMessage = new Label();
		hblogin.getChildren().addAll(btnLogin, btnBack_home2);

		// Adding Nodes to GridPane layout
		gridPane.add(lblUserName, 0, 0);
		gridPane.add(txtUserName, 1, 0);
		gridPane.add(lblPassword, 0, 1);
		gridPane.add(pf, 1, 1);
		gridPane.add(hblogin, 1, 3);
		gridPane.add(lblMessage, 1, 2);

		// Reflection for gridPane
		Reflection reflection = new Reflection();
		reflection.setFraction(0.7f);
		gridPane.setEffect(reflection);

		// DropShadow effect
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(5);
		dropShadow.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text = new Text("Login Portal");
		text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text.setEffect(dropShadow);

		// Adding text to HBox
		hb.getChildren().add(text);

		// Add ID's to Nodes
		bp.setId("bp");
		gridPane.setId("root");
		btnLogin.setId("btnLogin");
		btnBack_home2.setId("btnLogin");
		text.setId("text");

		// Action for btnLogin

		// Add HBox and GridPane layout to BorderPane Layout
		bp.setTop(hb);
		bp.setCenter(gridPane);

		// Adding BorderPane to the scene and loading CSS
		Scene scene_login = new Scene(bp);
		scene_login.getStylesheets().add(StartupPage.class.getResource("application.css").toExternalForm());
		// Login Portal Code end
		// *************************************************************************************

		// Signup Portal Code
		// start**********************************************************************************
		BorderPane bp_signup = new BorderPane();
		bp_signup.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb_signup = new HBox();
		hb_signup.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane_signup = new GridPane();
		gridPane_signup.setPadding(new Insets(20, 20, 20, 20));
		gridPane_signup.setHgap(2);
		gridPane_signup.setVgap(5);
		gridPane_signup.setAlignment(Pos.CENTER);

		// Implementing Nodes for GridPane

		// Personal Details
		Text personaldetails = new Text("Personal Details");
		personaldetails.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
		Text addressdetails = new Text("Address Details");
		addressdetails.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
		Text accountdetails = new Text("Account Details");
		accountdetails.setFont(Font.font("Courier New", FontWeight.BOLD, 18));
		Label lbl = new Label("Username");
		final TextField txtUser = new TextField();
		Label dateob = new Label("Date of Birth");
		final TextField dofbirth = new TextField();
		Label aadhar = new Label("Aadhar Number");
		final TextField aadharNumber = new TextField();
		Label email = new Label("Email ID");
		final TextField mailId = new TextField();
		Label contact = new Label("Contact Number");
		final TextField contactNumber = new TextField();
		Label Pincode = new Label("Pincode");
		final TextField pincode = new TextField();
		Label city = new Label("City");
		final TextField City = new TextField();
		Label state = new Label("State");
		ComboBox<String> Statee = new ComboBox<>();
		Statee.getItems().addAll("Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa",
				"Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", " Kerala",
				"Madhya Pradesh", "Maharashtra", "Manipur", " Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
				"Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh", "Uttarakhand");
		Statee.setPromptText("Select State");
		final ToggleGroup tg = new ToggleGroup();
		Label gender = new Label("Gender:		");
		final RadioButton rbm = new RadioButton("Male");
		rbm.setToggleGroup(tg);
		final RadioButton rbf = new RadioButton("Female");
		rbf.setToggleGroup(tg);
		final RadioButton rbo = new RadioButton("Others");
		rbo.setToggleGroup(tg);
		Label PAN = new Label("PAN number");
		final TextField panNumber = new TextField();
		Label an = new Label("Account number");
		final TextField accNumber = new TextField();
		Label cisc = new Label("CISC");
		final TextField ciscc = new TextField();
		Label permanentAddress = new Label("Permanent Address");
		final TextField pa = new TextField();
		Label bn = new Label("Branch Name");
		final TextField branchName = new TextField();
		Label bc = new Label("IFSC");
		final TextField branchCode = new TextField();

		Label lblPassword_signup = new Label("Password");
		final PasswordField pf_signup = new PasswordField();
		Label confirmPassword = new Label("Confirm Password");
		final PasswordField p_signup = new PasswordField();

		Button btn_signup = new Button("Sign Up");
		final Label lblMessage_signup = new Label();

		HBox hbrb = new HBox(20);
		hbrb.getChildren().addAll(gender, rbm, rbf, rbo);
		HBox hb_signup_btn = new HBox(20);
		hb_signup_btn.getChildren().addAll(btn_signup, btnBack_home);

		// Adding Nodes to GridPane layout
		// Personal Details
		gridPane_signup.add(personaldetails, 0, 0, 2, 1);
		gridPane_signup.add(lbl, 0, 1);
		gridPane_signup.add(txtUser, 1, 1);
		gridPane_signup.add(dateob, 2, 1);
		gridPane_signup.add(dofbirth, 3, 1);
		gridPane_signup.add(aadhar, 4, 1);
		gridPane_signup.add(aadharNumber, 5, 1);
		gridPane_signup.add(PAN, 0, 2);
		gridPane_signup.add(panNumber, 1, 2);
		gridPane_signup.add(contact, 2, 2);
		gridPane_signup.add(contactNumber, 3, 2);
		gridPane_signup.add(email, 4, 2);
		gridPane_signup.add(mailId, 5, 2);
		gridPane_signup.add(hbrb, 0, 3, 3, 1);

		// Address Details
		gridPane_signup.add(addressdetails, 0, 5, 2, 1);
		gridPane_signup.add(permanentAddress, 0, 6);
		gridPane_signup.add(pa, 1, 6);
		gridPane_signup.add(city, 2, 6);
		gridPane_signup.add(City, 3, 6);
		gridPane_signup.add(Pincode, 4, 6);
		gridPane_signup.add(pincode, 5, 6);
		gridPane_signup.add(state, 0, 7);
		gridPane_signup.add(Statee, 1, 7);

		// Account Details
		gridPane_signup.add(accountdetails, 0, 9, 2, 1);
		gridPane_signup.add(an, 0, 10);
		gridPane_signup.add(accNumber, 1, 10);
		gridPane_signup.add(cisc, 2, 10);
		gridPane_signup.add(ciscc, 3, 10);
		gridPane_signup.add(bn, 0, 11);
		gridPane_signup.add(branchName, 1, 11);
		gridPane_signup.add(bc, 2, 11);
		gridPane_signup.add(branchCode, 3, 11);
		gridPane_signup.add(lblPassword_signup, 0, 12);
		gridPane_signup.add(pf_signup, 1, 12);
		gridPane_signup.add(confirmPassword, 2, 12);
		gridPane_signup.add(p_signup, 3, 12);

		// Sign up label
		gridPane_signup.add(lblMessage_signup, 2, 15, 2, 1);
		// Adding buttons
		gridPane_signup.add(hb_signup_btn, 2, 16, 2, 1);

		// Reflection for gridPane_signup
		Reflection reflection_signup = new Reflection();
		reflection_signup.setFraction(0.7f);
		gridPane_signup.setEffect(reflection_signup);

		// DropShadow effect
		DropShadow dropShadow_signup = new DropShadow();
		dropShadow_signup.setOffsetX(5);
		dropShadow_signup.setOffsetY(5);

		// Adding text_signup and DropShadow effect to it
		Text text_signup = new Text("Sign Up Portal");
		text_signup.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text_signup.setEffect(dropShadow_signup);

		// Adding text_signup to HBox
		hb_signup.getChildren().add(text_signup);

		// Add ID's to Nodes
		bp_signup.setId("bp");
		gridPane_signup.setId("root");
		btn_signup.setId("btnLogin");
		btnBack_home.setId("btnLogin");
		text_signup.setId("text");

		// Add HBox and GridPane layout to BorderPane Layout
		bp_signup.setTop(hb_signup);
		bp_signup.setCenter(gridPane_signup);

		// Adding BorderPane to the scene and loading CSS
		Scene scene_signup = new Scene(bp_signup);
		scene_signup.getStylesheets().add(StartupPage.class.getResource("application.css").toExternalForm());
		// Signup Portal Code
		// end*******************************************************************************

		// OTP Window Code
		// start********************************************************************************
		BorderPane bp_otp = new BorderPane();
		bp_otp.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb_otp = new HBox();
		hb_otp.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane_otp = new GridPane();
		gridPane_otp.setPadding(new Insets(20, 20, 20, 20));
		gridPane_otp.setHgap(5);
		gridPane_otp.setVgap(5);
		gridPane_otp.setAlignment(Pos.CENTER);

		// Implementing Nodes for GridPane
		Label otpLabel = new Label("Enter the OTP sent to your registered mobile number");
		TextField otpText = new TextField();
		Button otpButton = new Button("Validate OTP");
		gridPane_otp.add(otpLabel, 0, 0);
		gridPane_otp.add(otpText, 1, 0);
		gridPane_otp.add(otpButton, 1, 3);

		// Adding Nodes to GridPane layout

		// Reflection for gridPane_otp
		Reflection reflection_otp = new Reflection();
		reflection_otp.setFraction(0.7f);
		gridPane_otp.setEffect(reflection_otp);

		// DropShadow effect
		DropShadow dropShadow_otp = new DropShadow();
		dropShadow_otp.setOffsetX(5);
		dropShadow_otp.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Text text_otp = new Text("OTP Verification");
		text_otp.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text_otp.setEffect(dropShadow_otp);

		// Adding text to HBox
		hb_otp.getChildren().add(text_otp);

		// Add ID's to Nodes
		bp_otp.setId("bp");
		gridPane_otp.setId("root");
		text_otp.setId("text");
		otpButton.setId("btnLogin");

		// Add HBox and GridPane layout to BorderPane Layout
		bp_otp.setTop(hb_otp);
		bp_otp.setCenter(gridPane_otp);

		// Adding BorderPane to the scene and loading CSS
		Scene scene_otp = new Scene(bp_otp);
		scene_otp.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// OTP Window Code
		// end********************************************************************************

		// Payto Others Portal start****************************************code
		// change[23/7]-P
		BorderPane make_payment_others = new BorderPane();
		make_payment_others.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb_makepayment_others = new HBox(200);
		hb_makepayment_others.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane_makepayment_others = new GridPane();
		gridPane_makepayment_others.setPadding(new Insets(20, 20, 20, 20));
		gridPane_makepayment_others.setHgap(5);
		gridPane_makepayment_others.setVgap(5);
		gridPane_makepayment_others.setAlignment(Pos.CENTER);

		// Implementing Nodes for GridPane
		Label AmoutToSend_others = new Label("Amount: ");
		TextField AmoutToSendText_others = new TextField();
		Label SelectBenefeciary_others = new Label(" Beneficiary Name: ");
		TextField SelectBenefeciaryText_others = new TextField();
		Label SelectBenefeciaryaccno_others = new Label("Beneficiary Account Number: ");
		TextField SelectBenefeciaryaccnoText_others = new TextField();
		Label ifsc_others = new Label(" IFSC Code: ");
		TextField ifsc_othersText = new TextField();
		Label Bank_others = new Label(" Bank Name: ");
		TextField Bank_others_others = new TextField();
		Label Enterpwd_others = new Label("Enter your Online Banking Password : ");
		PasswordField EnterpwdText_others = new PasswordField();
		Label benefeciaryMsg_others = new Label();
		Button SendButton_others = new Button("Send");

		gridPane_makepayment_others.add(AmoutToSend_others, 0, 0);
		gridPane_makepayment_others.add(AmoutToSendText_others, 1, 0);
		gridPane_makepayment_others.add(SelectBenefeciary_others, 0, 1);
		gridPane_makepayment_others.add(SelectBenefeciaryText_others, 1, 1);
		gridPane_makepayment_others.add(SelectBenefeciaryaccno_others, 0, 2);
		gridPane_makepayment_others.add(SelectBenefeciaryaccnoText_others, 1, 2);
		gridPane_makepayment_others.add(ifsc_others, 0, 3);
		gridPane_makepayment_others.add(ifsc_othersText, 1, 3);
		gridPane_makepayment_others.add(Bank_others, 0, 4);
		gridPane_makepayment_others.add(Bank_others_others, 1, 4);
		gridPane_makepayment_others.add(Enterpwd_others, 0, 5);
		gridPane_makepayment_others.add(EnterpwdText_others, 1, 5);

		gridPane_makepayment_others.add(benefeciaryMsg_others, 1, 8);

		gridPane_makepayment_others.add(SendButton_others, 1, 9);

		// Adding Nodes to GridPane layout

		// Reflection for gridPane_makepayment_others
		Reflection reflectionMakepayment_others = new Reflection();
		reflectionMakepayment_others.setFraction(0.7f);
		gridPane_makepayment_others.setEffect(reflectionMakepayment_others);

		// DropShadow effect
		DropShadow dropShadow_makepayment_others = new DropShadow();
		dropShadow_makepayment_others.setOffsetX(5);
		dropShadow_makepayment_others.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Image image_makepayment_others = new Image("FinCorp.png");
		ImageView logo_makepayment_others = new ImageView(image_makepayment_others);
		logo_makepayment_others.setFitHeight(200);
		logo_makepayment_others.setFitWidth(800);
		logo_makepayment_others.setEffect(dropShadow_home);
		Text text_makepayment_others = new Text("Payment");
		text_makepayment_others.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text_makepayment_others.setEffect(dropShadow_makepayment_others);

		// Adding back Button
		Button Makepaymentback_others = new Button("Back");
		Makepaymentback_others.setAlignment(Pos.CENTER_RIGHT);
		Makepaymentback_others.setFont(Font.font("", FontWeight.BOLD, 14));
		Makepaymentback_others.setMinHeight(30);
		Makepaymentback_others.setMinWidth(90);

		// Adding text to HBox
		hb_makepayment_others.getChildren().addAll(logo_makepayment_others, Makepaymentback_others);

		// Adding text paymnet to other Hbox

		// Add ID's to Nodes
		Makepaymentback_others.setId("btnLogin");
		make_payment_others.setId("bp");
		gridPane_makepayment_others.setId("root");
		text_makepayment_others.setId("text");
		Makepaymentback_others.setMinWidth(80);
		Makepaymentback_others.setMinHeight(20);
		Makepaymentback_others.setAlignment(Pos.CENTER);

		// Add HBox and GridPane layout to BorderPane Layout
		make_payment_others.setTop(hb_makepayment_others);
		make_payment_others.setCenter(gridPane_makepayment_others);

		// Adding BorderPane to the scene and loading CSS
		Scene scene_makepayment_others = new Scene(make_payment_others);
		scene_makepayment_others.getStylesheets()
				.add(StartupPage.class.getResource("application.css").toExternalForm());
		// Payto Others Portal end******************************************code
		// change[23/7]-P

		// Payment Portal
		// start************************************************************code
		// change[23/7]-P
		BorderPane make_payment = new BorderPane();
		make_payment.setPadding(new Insets(10, 50, 50, 50));

		// Adding HBox
		HBox hb_makepayment = new HBox(200);
		hb_makepayment.setPadding(new Insets(20, 20, 20, 30));

		// Adding GridPane
		GridPane gridPane_makepayment = new GridPane();
		gridPane_makepayment.setPadding(new Insets(20, 20, 20, 20));
		gridPane_makepayment.setHgap(5);
		gridPane_makepayment.setVgap(5);
		gridPane_makepayment.setAlignment(Pos.CENTER);

		// Implementing Nodes for GridPane
		Label AmoutToSend = new Label("Amount: ");
		TextField AmoutToSendText = new TextField();
		ComboBox<String> choice_makepayment = new ComboBox<>(); // <...> is used for any list
		Label selectbenefeciary = new Label("Select Beneficiary: ");
		choice_makepayment.getItems().addAll("Vachaspati", "Priyanshu", "Sowmya", "Surya", "Arjun", "Priya");
		choice_makepayment.setPromptText("Choose a Beneficiary");
		choice_makepayment.setEditable(true);
		Label Enterpwd = new Label("Enter your Online Banking Password : ");
		PasswordField EnterpwdText = new PasswordField();
		Label benefeciaryMsg = new Label("");
		Button SendButton = new Button("Send");

		gridPane_makepayment.add(AmoutToSend, 0, 0);
		gridPane_makepayment.add(AmoutToSendText, 1, 0);
		gridPane_makepayment.add(selectbenefeciary, 0, 1);
		gridPane_makepayment.add(choice_makepayment, 1, 1);
		gridPane_makepayment.add(Enterpwd, 0, 2);
		gridPane_makepayment.add(EnterpwdText, 1, 2);
		gridPane_makepayment.add(benefeciaryMsg, 1, 6);

		gridPane_makepayment.add(SendButton, 1, 7);

		// Adding Nodes to GridPane layout

		// Reflection for gridPane_makepayment
		Reflection reflection_makepayment = new Reflection();
		reflection_makepayment.setFraction(0.7f);
		gridPane_makepayment.setEffect(reflection_makepayment);

		// DropShadow effect
		DropShadow dropShadow_makepayment = new DropShadow();
		dropShadow_makepayment.setOffsetX(5);
		dropShadow_makepayment.setOffsetY(5);

		// Adding text and DropShadow effect to it
		Image image_makepayment = new Image("FinCorp.png");
		ImageView logo_makepayment = new ImageView(image_makepayment);
		logo_makepayment.setFitHeight(200);
		logo_makepayment.setFitWidth(800);
		logo_makepayment.setEffect(dropShadow_home);
		Text text_makepayment = new Text("Payment");
		text_makepayment.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
		text_makepayment.setEffect(dropShadow_makepayment);

		// Adding back Button
		Button Makepaymentback = new Button("Back");
		Makepaymentback.setFont(Font.font("", FontWeight.BOLD, 14));

		Makepaymentback.setAlignment(Pos.CENTER_RIGHT);

		// Adding text to HBox
		hb_makepayment.getChildren().addAll(logo_makepayment, Makepaymentback);

		// Adding text paymnet to other Hbox

		// Add ID's to Nodes
		make_payment.setId("bp");
		Makepaymentback.setId("btnLogin");
		gridPane_makepayment.setId("root");
		text_makepayment.setId("text");
		Makepaymentback.setMinWidth(100);
		Makepaymentback.setMinHeight(40);
		Makepaymentback.setAlignment(Pos.CENTER);

		// Add HBox and GridPane layout to BorderPane Layout
		make_payment.setTop(hb_makepayment);
		make_payment.setCenter(gridPane_makepayment);

		// Adding BorderPane to the scene and loading CSS
		Scene scene_makepayment = new Scene(make_payment);
		scene_makepayment.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// Payment Portal
		// end**************************************************************code
		// change[23/7]-P

		// Loggedin Window
		// start********************************************************************************
		BorderPane root_log = new BorderPane();
//		GridPane grid_center = new GridPane();
		HBox hbox_center = new HBox();
		VBox vbox_center1 = new VBox();
		vbox_center1.setPadding(new Insets(10, 10, 10, 0));
		VBox vbox_center2 = new VBox();
		vbox_center2.setPadding(new Insets(10, 0, 10, 0));
		HBox hbox_pay = new HBox();
		hbox_pay.setPadding(new Insets(10, 0, 10, 0));
		VBox vb_logo = new VBox();
		vb_logo.setPadding(new Insets(10, 0, 10, 0));

		// Creating text Labels
		Label text1 = new Label("");
		Label text1_ = new Label("");
		Label text2 = new Label("");
		Label text2_ = new Label("");
		Label text3 = new Label("");
		Label text3_ = new Label("");
		Label text4 = new Label("");
		Label text4_ = new Label("");
		Label text5 = new Label("");
		Label text5_ = new Label("");
		Label balance = new Label("");
		balance.setPadding(new Insets(0, 0, 0, 30));

		// create a menu
		// start----------------------------------------------------------------------
		Menu menu1 = new Menu("My Accounts");
		Menu menu2 = new Menu("Transaction History");
		Menu menu3 = new Menu("My Cards");
		Menu menu4 = new Menu("Make Payments");
		Menu menu5 = new Menu("Logout");

		// create menuitems in menu 1
		MenuItem m1_1 = new MenuItem("Personal Details");
		MenuItem m1_2 = new MenuItem("Address Details");
		MenuItem m1_3 = new MenuItem("Account Details");

		// create menuitems in menu 2
		MenuItem m2_1 = new MenuItem("Credit History");
		MenuItem m2_2 = new MenuItem("Debit History");

		// create menuitems in menu 3
		MenuItem m3_1 = new MenuItem("Debit Card");
		MenuItem m3_2 = new MenuItem("Credit Card");

		// create menuitems in menu 4
		MenuItem m4_1 = new MenuItem("Pay to Beneficiary");
		MenuItem m4_2 = new MenuItem("Others");

		// create menuitems in menu 5
		MenuItem m5_1 = new MenuItem("Back to Home Page");
		MenuItem m5_2 = new MenuItem("Back to Login Page");

		// add menu items to menu1
		menu1.getItems().add(m1_1);
		menu1.getItems().add(m1_2);
		menu1.getItems().add(m1_3);

		// add menu items to menu2
		menu2.getItems().add(m2_1);
		menu2.getItems().add(m2_2);

		// add menu items to menu2
		menu3.getItems().add(m3_1);
		menu3.getItems().add(m3_2);

		// add menu items to menu4
		menu4.getItems().add(m4_1);
		menu4.getItems().add(m4_2);

		// add menu items to menu5
		menu5.getItems().add(m5_1);
		menu5.getItems().add(m5_2);

		// Adding Action to menuitems
		m1_1.setOnAction(new EventHandler<ActionEvent>() {
			// code change 23/07/22 S
			public void handle(ActionEvent ae) {
				System.out.println(enteredUserName);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql: //localhost:3306/javaproject", "root",
							"1234");
					Statement stmt = con.createStatement();
					System.out.println("select name,dob,email,contact,a_no from Personal_Details p where p.name='"
							+ enteredUserName + "'");
					ResultSet rs = stmt
							.executeQuery("select name,dob,email,contact,a_no from Personal_Details p where p.name='"
									+ enteredUserName + "'");
					while (rs.next()) {

						text1.setText("Name:");text1_.setText(rs.getString(1));
						text2.setText("D.O.B.:");text2_.setText(rs.getString(2));
						text3.setText("Email:");text3_.setText(rs.getString(3));
						text4.setText("Contact:");text4_.setText(rs.getString(4));
						text5.setText("Aadhar No.:");text5_.setText(rs.getString(5));
						balance.setText("");
					}
				} catch (Exception ae1) {
					System.out.println("Exeption caught " + ae1);
				}

			}

		});

		m1_2.setOnAction(e -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root",
						"1234");
				Statement stmt = con.createStatement();
				System.out.println(
						"select address,city,pincode,state from Address_Details a where person_id IN(select person_id from Personal_Details where name='"
								+ txtUserName.getText().toString() + "')");
				ResultSet rs = stmt.executeQuery(
						"select address,city,pincode,state from Address_Details a where person_id IN(select person_id from Personal_Details where name='"
								+ enteredUserName + "')");
				while (rs.next()) {
					text1.setText("Address:");text1_.setText(rs.getString(1));
					text2.setText("City:");text2_.setText(rs.getString(2));
					text3.setText("Pincode:");text3_.setText(Integer.toString(rs.getInt(3)));
					text4.setText("State:");text4_.setText(rs.getString(4));
					text5.setText("");text5_.setText("");
					balance.setText("");
				}
			} catch (Exception ae) {
				System.out.println("Caught Exception " + ae);
			}
		});

		m1_3.setOnAction(e -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root",
						"1234");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select acc_no,ifsc,b_name from Account_Details a where person_id IN(select person_id from Personal_Details where name='"
								+ enteredUserName + "')");

				while (rs.next()) {
					text1.setText("Account No.:");text1_.setText(rs.getString(1));
					text2.setText("IFSC:");text2_.setText(rs.getString(2));
					text3.setText("Branch Name:");text3_.setText(rs.getString(3));
					text4.setText("");text4_.setText("");
					text5.setText("");text5_.setText("");
					balance.setText("");
				}
			} catch (Exception ae) {
				System.out.println("Caught Exception " + ae);
			}
		});
		m2_1.setOnAction(e -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root",
						"1234");
				Statement stmt = con.createStatement();

				ResultSet rs1 = stmt.executeQuery(
						"select DISTINCT c.name AS NAME,c.cre_money AS AMOUNT,c.date AS DATE from Personal_Details p,Credit c,Debit d where c.name='"
								+ enteredUserName + "'");
				System.out.println("\n\n\n\n\n" + enteredUserName + ":");
				System.out.println("Amount Credited          Date  ");
				text1.setText("Amount Credited         		 Date  ");
				for(int j=0; j<4; j++) hist[j]="";
				int i=-1;
				while (rs1.next()) {
					hist[++i]=rs1.getInt(2) + "       		" + rs1.getString(3) + "  ";
					System.out.println(rs1.getInt(2) + "       		" + rs1.getString(3) + "  ");
				}
				text2.setText(hist[0]);
				text3.setText(hist[1]);
				text4.setText(hist[2]);
				text5.setText(hist[3]);
				text1_.setText("");
				text2_.setText("");
				text3_.setText("");
				text4_.setText("");
				text5_.setText("");

			} catch (Exception ae) {
				System.out.println("Caught Exception " + ae);
			}
		});
		m2_2.setOnAction(e -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root",
						"1234");
				Statement stmt = con.createStatement();

				ResultSet rs1 = stmt.executeQuery(
						"select DISTINCT d.name AS NAME,d.de_money AS AMOUNT,d.date AS DATE from Personal_Details p,Debit d where d.name='"
								+ enteredUserName + "'");
				System.out.println("\n\n\n\n\n" + enteredUserName + ":");
				System.out.println("Amount Debited          Date  ");
				text1.setText("Amount Debited         		 Date  ");
				for(int j=0; j<4; j++) hist[j]="";
				int i=-1;
				while (rs1.next()) {
					hist[++i]=rs1.getInt(2) + "       		" + rs1.getString(3) + "  ";
					System.out.println(rs1.getInt(2) + "       		" + rs1.getString(3) + "  ");
				}
				text2.setText(hist[0]);
				text3.setText(hist[1]);
				text4.setText(hist[2]);
				text5.setText(hist[3]);
				text1_.setText("");
				text2_.setText("");
				text3_.setText("");
				text4_.setText("");
				text5_.setText("");

			} catch (Exception ae) {
				System.out.println("Caught Exception " + ae);
			}
		});

//		code change start [23/7]-P
		m4_1.setOnAction(e -> {
			EnterpwdText.setText("");
			AmoutToSendText.setText("");
			choice_makepayment.setValue("");
			stage.setScene(scene_makepayment);
			stage.setTitle("Pay to Beneficiary");
			stage.setFullScreen(true);
		});
		m4_2.setOnAction(e -> {
			AmoutToSendText_others.setText("");
			SelectBenefeciaryText_others.setText("");
			Bank_others_others.setText("");
			ifsc_othersText.setText("");
			SelectBenefeciaryaccnoText_others.setText("");
			EnterpwdText_others.setText("");
			stage.setScene(scene_makepayment_others);
			stage.setTitle("Pay Others");
			stage.setFullScreen(true);
		});
//		code change end [23/7]-P
		m5_1.setOnAction(e -> {
			stage.setScene(scene1);
			stage.setTitle("HomePage");
			stage.setFullScreen(true);
		});
		m5_2.setOnAction(e -> {
			stage.setScene(scene_login);
			stage.setTitle("Login Portal");
			stage.setFullScreen(true);
		});

		// create a menubar
		MenuBar mb = new MenuBar();
		mb.prefWidthProperty().bind(stage.widthProperty());

		// add menu to menubar
		mb.getMenus().addAll(menu1, menu2, menu3, menu4, menu5);
		// Menubar
		// end------------------------------------------------------------------------

		// Treeview
		// start---------------------------------------------------------------------
		TreeView<String> tree = new TreeView<>();

		TreeItem<String> rooot = new TreeItem<>("Options");

		TreeItem<String> branch1 = new TreeItem<>("Services");
		TreeItem<String> branch2 = new TreeItem<>("FAQ");
		TreeItem<String> branch3 = new TreeItem<>("Banking Channel");
		TreeItem<String> branch4 = new TreeItem<>("Loans");
		TreeItem<String> branch5 = new TreeItem<>("About Us");

		TreeItem<String> leaf1_1 = new TreeItem<>("Mobile Banking"); // Create leaves
		TreeItem<String> leaf1_2 = new TreeItem<>("Forex");
		TreeItem<String> leaf1_3 = new TreeItem<>("Insurance");
		TreeItem<String> leaf2_1 = new TreeItem<>("Personal FAQ");
		TreeItem<String> leaf2_2 = new TreeItem<>("Corporate FAQ");
		TreeItem<String> leaf3_1 = new TreeItem<>("Credit Card");
		TreeItem<String> leaf3_2 = new TreeItem<>("Debit Card");
		TreeItem<String> leaf3_3 = new TreeItem<>("UPI");
		TreeItem<String> leaf4_1 = new TreeItem<>("Personal Loan");
		TreeItem<String> leaf4_2 = new TreeItem<>("Home Loan");
		TreeItem<String> leaf4_3 = new TreeItem<>("Gold Loan");

		// Arranging treeview
		tree.setRoot(rooot);
		rooot.getChildren().addAll(branch1, branch2, branch3, branch4, branch5);
		branch1.getChildren().addAll(leaf1_1, leaf1_2, leaf1_3);
		branch2.getChildren().addAll(leaf2_1, leaf2_2);
		branch3.getChildren().addAll(leaf3_1, leaf3_2, leaf3_3);
		branch4.getChildren().addAll(leaf4_1, leaf4_2, leaf4_3);
		rooot.setExpanded(true);
//		branch1.setExpanded(true);
		branch2.setExpanded(true);
		branch3.setExpanded(true);
		branch4.setExpanded(true);

		// Treeview
		// end-----------------------------------------------------------------------

		// Make Balance button
		Button bal = new Button("Check Balance");
		bal.setFont(Font.font("", FontWeight.BOLD, 14));
		bal.setMinWidth(120);
		bal.setMinHeight(40);

		logo.setFitHeight(200);
		logo.setFitWidth(700);
		GridPane.setConstraints(logo, 1, 1, 1, 2);

		root_log.setLeft(tree);
		root_log.setTop(vb_logo);
		root_log.setBottom(hbox_pay);
//		root_log.setCenter(grid_center);
		root_log.setCenter(hbox_center);
		vb_logo.getChildren().addAll(logo, mb);
		hbox_pay.getChildren().addAll(bal, balance);
		hbox_pay.setAlignment(Pos.CENTER);
		vbox_center1.getChildren().addAll(text1, text2, text3, text4, text5);
		vbox_center1.setAlignment(Pos.CENTER_RIGHT);
		vbox_center2.getChildren().addAll(text1_, text2_, text3_, text4_, text5_);
		vbox_center2.setAlignment(Pos.CENTER_LEFT);
		hbox_center.getChildren().addAll(vbox_center1, vbox_center2);
		hbox_center.setAlignment(Pos.CENTER);

		// Setting Ids
		root_log.setId("root");
//		tree.setId("root");
		vbox_center1.setId("label1");
		balance.setId("label1");
		vbox_center2.setId("label2");
		hbox_center.setId("root");
//		vb_logo.setId("root");
//		vbox_center1.setId("root");
		bal.setId("btnLogin");

		Scene scene_log = new Scene(root_log, 800, 500);
		scene_log.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// Loggedin Window
		// end********************************************************************************

		// OTP button function in OTP portal
		otpButton.setOnAction(e -> {
			otpText.setText("");
			stage.setScene(scene1);
			stage.setTitle("HomePage");
			stage.setFullScreen(true);
		});

		// login button function in startup page
		login.setOnAction(ae -> {
			lblMessage.setText("");
			stage.setScene(scene_login);
			stage.setTitle("Login Portal");
			stage.setFullScreen(true);
		});

		// signup button function in startup page
		signup.setOnAction(ae -> {
			txtUser.setText("");
			mailId.setText("");
			dofbirth.setText("");
			aadharNumber.setText("");
			contactNumber.setText("");
			pincode.setText("");
			City.setText("");
			Statee.setValue(null);
			panNumber.setText("");
			accNumber.setText("");
			ciscc.setText("");
			pa.setText("");
			branchName.setText("");
			branchCode.setText("");
			pf_signup.setText("");
			p_signup.setText("");
			lblMessage_signup.setText("");
			stage.setScene(scene_signup);
			stage.setTitle("Signup Portal");
			stage.setFullScreen(true);
		});

		// login button function in login portal
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				enteredUserName = txtUserName.getText().toString();
				String enteredPassword = pf.getText().toString();
				try {
					int flag = 0;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql: //localhost:3306/javaproject", "root",
							"1234");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(
							"select pwd from Account_Details acc,Personal_Details p where p.person_id=acc.person_id and p.name='"
									+ enteredUserName + "'");
					while (rs.next()) {
						System.out.println("correct password:" + rs.getString(1) + " user password:" + enteredPassword);
						if (rs.getString(1).equals(enteredPassword)) {

							stage.setScene(scene_log);
							stage.setTitle("My Account");
							stage.setFullScreen(true);
							lblMessage.setText("");
							flag = 1;
						}
					}
					if (flag == 0) {
						lblMessage.setText("Wrong Username or Password!");
						lblMessage.setTextFill(Color.RED);
					}
				} catch (Exception e) {
					System.out.println("Caught an error");
				}
				txtUserName.setText("");
				pf.setText("");
				text1.setText("WELCOME");text1_.setText(enteredUserName);
				text2.setText("");text2_.setText("");
				text3.setText("");text3_.setText("");
				text4.setText("");text4_.setText("");
				text5.setText("");text5_.setText("");
				benefeciaryMsg.setText("");
				balance.setText("");
			}

		});

		SendButton.setOnAction(e -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root",
						"1234");
				Statement stmt = con.createStatement();

				int amt = Integer.parseInt(AmoutToSendText.getText());
				String beneficiary = choice_makepayment.getValue().toString();
				String beneficiaryEnteredPassword = EnterpwdText.getText().toString();
				System.out.println(" " + beneficiaryEnteredPassword);

				ResultSet rs = stmt.executeQuery(
						"select pwd from Account_Details acc,Personal_Details p where p.person_id=acc.person_id and p.name='"
								+ enteredUserName + "'");
				while (rs.next()) {
					if (rs.getString(1).equals(beneficiaryEnteredPassword)) {
						stmt.executeUpdate("Insert into Credit values('" + beneficiary + "'," + amt + ",'2022-07-25')");
						stmt.executeUpdate(
								"Insert into Debit values('" + enteredUserName + "'," + amt + ",'2022-07-25')");
						stmt.executeUpdate("UPDATE Account_Details set balance=balance-" + amt
								+ " where person_id IN(select person_id from Personal_Details where name='"
								+ enteredUserName + "')");
						stmt.executeUpdate("UPDATE Account_Details set balance=balance+" + amt
								+ " where person_id IN(select person_id from Personal_Details where name='"
								+ beneficiary + "')");
						benefeciaryMsg.setText("Money sent");
						EnterpwdText.setText("");
						AmoutToSendText.setText("");
						choice_makepayment.setValue("");
					} else
						benefeciaryMsg.setText("Wrong Password");
				}
			} catch (Exception ae) {
				System.out.println("Caught Exception " + ae);
			}
		});

		SendButton_others.setOnAction(e -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root",
						"1234");
				Statement stmt = con.createStatement();

				int amt = Integer.parseInt(AmoutToSendText_others.getText());
				String beneficiaryEnteredPassword = EnterpwdText_others.getText().toString();

				ResultSet rs1 = stmt.executeQuery(
						"select pwd from Account_Details acc,Personal_Details p where p.person_id=acc.person_id and p.name='"
								+ enteredUserName + "'");
				System.out.println(
						"select balance from Account_Details where person_id IN(select person_id from Personal_Details where name='"
								+ enteredUserName + "')");
				while (rs1.next()) {
					System.out.println(rs1.getString(1) + " " + beneficiaryEnteredPassword + " ");
					if (rs1.getString(1).equals(beneficiaryEnteredPassword)) {
						stmt.executeUpdate(
								"Insert into Debit values('" + enteredUserName + "'," + amt + ",'2022-07-25')");
						stmt.executeUpdate("UPDATE Account_Details set balance=balance-" + amt
								+ " where person_id IN(select person_id from Personal_Details where name='"
								+ enteredUserName + "')");
						benefeciaryMsg_others.setText("Money sent succesfully");
						AmoutToSendText_others.setText("");
						SelectBenefeciaryText_others.setText("");
						Bank_others_others.setText("");
						ifsc_othersText.setText("");
						SelectBenefeciaryaccnoText_others.setText("");
						EnterpwdText_others.setText("");
					} else {
						benefeciaryMsg_others.setText("Wrong Password");
					}

				}
			}

			catch (Exception ae) {
				System.out.println("Caught Exception " + ae);
			}
		});
		bal.setOnAction(e -> {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root",
						"1234");
				Statement stmt = con.createStatement();
				System.out.println(
						"select balance from Account_Details where person_id IN(select person_id from Personal_Details where name='"
								+ enteredUserName + "')");
				ResultSet rs = stmt.executeQuery(
						"select balance from Account_Details where person_id IN(select person_id from Personal_Details where name='"
								+ enteredUserName + "')");
				while (rs.next())
					balance.setText("Rs " + Integer.toString(rs.getInt(1)) + ".00");

			} catch (Exception ae) {
				System.out.println("Caugth Exception " + ae);
			}

		});

//		code change start [22/7]-P
		// Loggedin Back buttons Action
		Makepaymentback.setOnAction(e -> {
			stage.setScene(scene_log);
			stage.setTitle("My Account");
			stage.setFullScreen(true);
		});
		Makepaymentback_others.setOnAction(e -> {
			stage.setScene(scene_log);
			stage.setTitle("My Account");
			stage.setFullScreen(true);
		});
//		code change end [22/7]-P

		// Home Back buttons Action
		btnBack_home.setOnAction(e -> {
			stage.setScene(scene1);
			stage.setTitle("HomePage");
			stage.setFullScreen(true);
		});
		btnBack_home2.setOnAction(e -> {
			stage.setScene(scene1);
			stage.setTitle("HomePage");
			stage.setFullScreen(true);
		});

		// Signup button function in Signup portal
		btn_signup.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				String Username = txtUser.getText();
				String Email = mailId.getText();
				String Dob = dofbirth.getText();
				String Aadhar = aadharNumber.getText();
				String Contact = contactNumber.getText();
				String Accno = accNumber.getText();
				String IFSC = branchCode.getText();
				String Branch_name = branchName.getText();
				String Password = pf_signup.getText();
				String cnfPassword = p_signup.getText();
				String Address = pa.getText();
				String State = Statee.getValue();
				String Cityy = City.getText();
				String Pincodee = pincode.getText();
//				System.out.println(State);
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql: //localhost:3306/javaproject", "root",
							"1234");
					Statement stmt = con.createStatement();

					if (cnfPassword.equals(Password)) {
						stmt.executeUpdate("insert into Personal_Details(name,dob,email,contact,a_no) values('"
								+ Username + "','" + Dob + "','" + Email + "','" + Contact + "','" + Aadhar + "')");
						stmt.executeUpdate("insert into Address_Details(address,city,pincode,state) values('" + Address
								+ "','" + Cityy + "'," + Pincodee + ",'" + State + "')");
						stmt.executeUpdate("insert into Account_Details(acc_no,ifsc,b_name,pwd,balance) values('" + Accno
								+ "','" + IFSC + "','" + Branch_name + "','" + Password + "',10000)");
						stage.setScene(scene_otp);
						stage.setFullScreen(true);
						
					} else {
						lblMessage_signup.setText("Password does not match");
						lblMessage_signup.setTextFill(Color.RED);
					}

				} catch (Exception e) {
					System.out.println("Caught an error" + e);
					lblMessage_signup.setTextFill(Color.RED);
					lblMessage_signup.setText("Please fill all the mandatory fields");
				}

			}

		});

		scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		// Default Scene
		stage.setScene(scene1);
		stage.getIcons().add(image); // Adding custom icon
		stage.setFullScreenExitHint("");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}