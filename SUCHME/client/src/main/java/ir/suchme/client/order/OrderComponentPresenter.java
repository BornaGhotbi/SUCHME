package ir.suchme.client.order;

import ir.suchme.client.util.NotificationUtil;
import ir.suchme.client.util.SuchmeClient;
import ir.suchme.common.dto.base.BaseResponseDTO;
import ir.suchme.common.dto.component.ComponentDTO;
import ir.suchme.common.dto.component.RequestSearchComponentDTO;
import ir.suchme.common.dto.component.ResponseSearchComponentDTO;
import ir.suchme.common.dto.order.RequestOrderComponentDTO;
import ir.suchme.common.dto.supplier.RequestSearchSupplierDTO;
import ir.suchme.common.dto.supplier.ResponseSearchSupplierDTO;
import ir.suchme.common.dto.supplier.SupplierDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class OrderComponentPresenter implements Initializable {
    @FXML private TextField searchField;
    @FXML private TextField numOfValues;
    @FXML private Button searchButton;
    @FXML private Button acceptButton;
    @FXML private TableView<ComponentDTO> table;
    @FXML private TableColumn<ComponentDTO, String> name;
    @FXML private TableColumn<ComponentDTO, Integer> maxValue;
    @FXML private TableColumn<ComponentDTO, Integer> minValue;
    @FXML private TableColumn<ComponentDTO, String> supplierName;
    @FXML private TextField componentNameBox;
    @FXML private RadioButton chooseSupplierFromExisting;
    @FXML private RadioButton createNewSupplier;
    @FXML private ChoiceBox<SupplierDTO> selectedSupplierName;
    @FXML private TextField newSupplierName;
    @FXML private TextField newComponentPrice;


//    HashMap<String,HashMap<String,Integer>> componentSuppliersTimeToSupplyMap=new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maxValue.setCellValueFactory(new PropertyValueFactory<>("maxValue"));
        minValue.setCellValueFactory(new PropertyValueFactory<>("minValue"));
        supplierName.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        ResponseSearchSupplierDTO suppliers = SuchmeClient.getInstance().postRequestAndWaitForResponse("/search/supplier", new RequestSearchSupplierDTO(), ResponseSearchSupplierDTO.class);
        selectedSupplierName.setItems(FXCollections.observableArrayList(suppliers.getSupplierDTOS()));

        searchButton.setOnAction(event -> {
            SuchmeClient client = SuchmeClient.getInstance();
            ResponseSearchComponentDTO out = client.postRequestAndWaitForResponse("/search/component", new RequestSearchComponentDTO(searchField.getText()),ResponseSearchComponentDTO.class);
            NotificationUtil.check(out);
            ObservableList<ComponentDTO> items= FXCollections.observableArrayList(out.getComponentDTOS());
            table.setItems(items);
/*            for(ComponentDTO c:out.getComponentDTOS()){
                if(!componentSuppliersTimeToSupplyMap.containsKey(c.getId())){
                    componentSuppliersTimeToSupplyMap.put(c.getId(),new HashMap<>());
                    componentSuppliersTimeToSupplyMap.get(c.getId()).put(c.getSupplierId(),c.getTimeToSupply());
                }
                else if(componentSuppliersTimeToSupplyMap.get(c.getId()).get(c.getSupplierId())!=null)
                    throw new IllegalArgumentException("Something horrible happened");
                else
                    componentSuppliersTimeToSupplyMap.get(c.getId()).put(c.getSupplierId(),c.getTimeToSupply());
            }*/
        });

        acceptButton.setOnAction(event -> {
            SuchmeClient client = SuchmeClient.getInstance();
            BaseResponseDTO out = client.postRequestAndWaitForResponse("/order/component", new RequestOrderComponentDTO(
                    table.getSelectionModel().getSelectedItem()!=null?table.getSelectionModel().getSelectedItem().getId():null
                    ,chooseSupplierFromExisting.isSelected()?selectedSupplierName.getSelectionModel().getSelectedItem()!=null?selectedSupplierName.getSelectionModel().getSelectedItem().getId():null:null
                    ,createNewSupplier.isSelected()?newSupplierName.getText():null
                    ,componentNameBox.getText()
                    ,newComponentPrice.getText()!=null&&!newComponentPrice.getText().isEmpty()?Integer.parseInt(newComponentPrice.getText()):null
                    ,numOfValues.getText()!=null&&!numOfValues.getText().isEmpty()?Integer.parseInt(numOfValues.getText()):null),BaseResponseDTO.class);
            NotificationUtil.OK(out);
        });

        numOfValues.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                numOfValues.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        newComponentPrice.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                newComponentPrice.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });


        chooseSupplierFromExisting.selectedProperty().addListener((obs, wasPreviouslySelected, isNowSelected) -> {
            if (isNowSelected) {
                createNewSupplier.setSelected(false);
                newSupplierName.setVisible(false);
                selectedSupplierName.setVisible(true);
            }
        });
        createNewSupplier.selectedProperty().addListener((obs, wasPreviouslySelected, isNowSelected) -> {
            if (isNowSelected) {
                chooseSupplierFromExisting.setSelected(false);
                newSupplierName.setVisible(true);
                selectedSupplierName.setVisible(false);
            }
        });

/*
        selectedSupplierName.setOnAction(event -> {
            if(chooseSupplierFromExisting.isSelected()&&table.getSelectionModel().getSelectedItem()!=null){
                if(componentSuppliersTimeToSupplyMap.get(table.getSelectionModel().getSelectedItem().getId()).get(selectedSupplierName.getSelectionModel().
                getSelectedItem().getId())!=null){
                    timeToBuild.setText(componentSuppliersTimeToSupplyMap.get(table.getSelectionModel().getSelectedItem().getId()).get(selectedSupplierName.getSelectionModel().
                            getSelectedItem().getId())+"");
                }
            }
        });*/
    }

}
