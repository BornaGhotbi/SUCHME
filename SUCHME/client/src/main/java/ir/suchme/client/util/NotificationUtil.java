package ir.suchme.client.util;

import ir.suchme.common.dto.base.BaseResponseDTO;
import javafx.scene.control.Alert;

import java.util.Objects;


public class NotificationUtil {

    public static boolean check(BaseResponseDTO responseDTO){
        try{
            if(!Objects.equals(responseDTO.getResponseCode(), "0")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText(responseDTO.getError());
                alert.showAndWait();
                return true;
            }
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("خطا در برقراری ارتباط");
            alert.showAndWait();
            return true;
        }
        return false;
    }

    public static void OK(BaseResponseDTO responseDTO){
            if (!check(responseDTO)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("موفقیت آمیز بود");
                alert.showAndWait();
            }
    }
}
