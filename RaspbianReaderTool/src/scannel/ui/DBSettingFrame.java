package scannel.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import scannel.reader.DatabaseUtility;
import scannel.reader.ReaderConfig;
import scannel.reader.ReaderConfig.DBType;

public class DBSettingFrame extends AnchorPane implements EventHandler<ActionEvent> {

    private ChoiceBox<DBType> db_type;
    private TextField ip;
    private TextField userid;
    private TextField password;
    private TextField db_name;

    private TextField readerid;
    private TextField table_name;
    private TextField fieldname_epc;
    private TextField fieldname_readerid;
    private TextField fieldname_time;
    private TextField fieldname_userBank;
    private TextField fieldname_tidBank;
    private TextField fieldname_rssi;

    public DBSettingFrame() {
        initComponents();
        setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: lightgrey;");
    }

    public DBSettingFrame(Node... arg0) {
        super(arg0);
    }

    private void initComponents() {

        getChildren().add(newLabel("DB Type: ", 30.0, 20.0));

        db_type = new ChoiceBox<>(loadDBOption());
        db_type.setOnAction(this);
        db_type.setValue(ReaderConfig.getInstance().getDBType());
        AnchorPane.setLeftAnchor(db_type, 150.0);
        AnchorPane.setTopAnchor(db_type, 20.0);
        getChildren().add(db_type);

        getChildren().add(newLabel("IP & port:", 30.0, 60.0));
        ip = newTextField(200, 150.0, 60.0);
        ip.setPromptText("ex. \"192.168.21.135:4001\"");
        getChildren().add(ip);

        getChildren().add(newLabel("DB Name:", 30.0, 100.0));
        db_name = newTextField(200, 150.0, 100.0);
        getChildren().add(db_name);

        getChildren().add(newLabel("User ID:", 30.0, 140.0));
        userid = newTextField(200, 150.0, 140.0);
        getChildren().add(userid);

        getChildren().add(newLabel("Password:", 30.0, 180.0));
        password = newTextField(200, 150.0, 180.0);
        getChildren().add(password);

        getChildren().add(newLabel("Reader ID:", 30.0, 220.0));
        readerid = newTextField(200, 150.0, 220.0);
        getChildren().add(readerid);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        AnchorPane.setLeftAnchor(separator, 430.0);
        AnchorPane.setTopAnchor(separator, 10.0);
        AnchorPane.setBottomAnchor(separator, 10.0);
        getChildren().add(separator);

        getChildren().add(newLabel("Table Name:", 480.0, 20.0));
        table_name = newTextField(160, 680.0, 20.0);
        getChildren().add(table_name);

        getChildren().add(newLabel("Field Name (EPC):", 480.0, 60.0));
        fieldname_epc = newTextField(160, 680.0, 60.0);
        getChildren().add(fieldname_epc);

        getChildren().add(newLabel("Field Name (Reader ID):", 480.0, 100.0));
        fieldname_readerid = newTextField(160, 680.0, 100.0);
        getChildren().add(fieldname_readerid);

        getChildren().add(newLabel("Field Name (Time):", 480.0, 140.0));
        fieldname_time = newTextField(160, 680.0, 140.0);
        getChildren().add(fieldname_time);

        getChildren().add(newLabel("Field Name (TID):", 480.0, 180.0));
        fieldname_tidBank = newTextField(160, 680.0, 180.0);
        getChildren().add(fieldname_tidBank);

        getChildren().add(newLabel("Field Name (User Bank):", 480.0, 220.0));
        fieldname_userBank = newTextField(160, 680.0, 220.0);
        getChildren().add(fieldname_userBank);

        getChildren().add(newLabel("Field Name (RSSI):", 480.0, 260.0));
        fieldname_rssi = newTextField(160, 680.0, 260.0);
        getChildren().add(fieldname_rssi);
    }

    private TextField newTextField(int prefWidth, double leftAnchor, double topAnchor) {
        TextField textField = new TextField();
        textField.setPrefWidth(prefWidth);
        AnchorPane.setLeftAnchor(textField, leftAnchor);
        AnchorPane.setTopAnchor(textField, topAnchor);
        return textField;
    }

    private Label newLabel(String s, double v, double v2) {
        Label db_title = new Label(s);
        db_title.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        AnchorPane.setLeftAnchor(db_title, v);
        AnchorPane.setTopAnchor(db_title, v2);
        return db_title;
    }

    private ObservableList<DBType> loadDBOption() {
        ObservableList<DBType> dblist = FXCollections.observableArrayList();
        dblist.addAll(DBType.values());

        return dblist;
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == db_type) {
            switch (db_type.getSelectionModel().getSelectedIndex()) {
                case 0:
                    break;
                case 1:
                    break;
            }
        }
    }

    public void saveDBSetting() {
        ReaderConfig.getInstance().setDBType(db_type.getValue());
        ReaderConfig.getInstance().setDBIP(ip.getText());
        ReaderConfig.getInstance().setDBName(db_name.getText());
        ReaderConfig.getInstance().setUserId(userid.getText());
        ReaderConfig.getInstance().setPassword(password.getText());

        ReaderConfig.getInstance().setReaderId(readerid.getText());
        ReaderConfig.getInstance().setTableName(table_name.getText());
        ReaderConfig.getInstance().setEPCFieldName(fieldname_epc.getText());
        ReaderConfig.getInstance().setReaderIdFieldName(fieldname_readerid.getText());
        ReaderConfig.getInstance().setTimeFieldName(fieldname_time.getText());
        ReaderConfig.getInstance().setTIDFieldName(fieldname_tidBank.getText());
        ReaderConfig.getInstance().setUserBankFieldName(fieldname_userBank.getText());
        ReaderConfig.getInstance().setRssiFieldName(fieldname_rssi.getText());

        DatabaseUtility.getInstance().setDBType(db_type.getValue());
        DatabaseUtility.getInstance().setDBParameters(ip.getText(), db_name.getText(), userid.getText(), password.getText());
        DatabaseUtility.getInstance().setTableParameters(table_name.getText()
                , fieldname_epc.getText()
                , fieldname_readerid.getText()
                , fieldname_time.getText()
                , fieldname_tidBank.getText()
                , fieldname_userBank.getText()
                , fieldname_rssi.getText());
        DatabaseUtility.getInstance().setReaderId(readerid.getText());
    }

    public void loadDBSetting() {
        db_type.setValue(ReaderConfig.getInstance().getDBType());
        ip.setText(ReaderConfig.getInstance().getDBIP());
        db_name.setText(ReaderConfig.getInstance().getDBName());
        userid.setText(ReaderConfig.getInstance().getUserId());
        password.setText(ReaderConfig.getInstance().getPassword());

        readerid.setText(ReaderConfig.getInstance().getReaderId());
        table_name.setText(ReaderConfig.getInstance().getTableName());
        fieldname_epc.setText(ReaderConfig.getInstance().getEPCFieldName());
        fieldname_readerid.setText(ReaderConfig.getInstance().getReaderIdFieldName());
        fieldname_time.setText(ReaderConfig.getInstance().getTimeFieldName());
        fieldname_tidBank.setText(ReaderConfig.getInstance().getTIDFieldName());
        fieldname_userBank.setText(ReaderConfig.getInstance().getUserBankFieldName());
        fieldname_rssi.setText(ReaderConfig.getInstance().getRssiFieldName());

        DatabaseUtility.getInstance().setDBType(db_type.getValue());
        DatabaseUtility.getInstance().setDBParameters(ip.getText(), db_name.getText(), userid.getText(), password.getText());
        DatabaseUtility.getInstance().setTableParameters(table_name.getText()
                , fieldname_epc.getText()
                , fieldname_readerid.getText()
                , fieldname_time.getText()
                , fieldname_tidBank.getText()
                , fieldname_userBank.getText()
                , fieldname_rssi.getText());
        DatabaseUtility.getInstance().setReaderId(readerid.getText());
    }
}
