package bank.Templates;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by 986298 on 6/12/2018.
 */
@FacesValidator("AmountValidator")
public class AmountValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        int amt = 0;
        boolean flag = false;

        try {
            amt = Integer.parseInt(o + "");
        } catch (Exception ex) {
            flag = true;
            FacesMessage msg =
                    new FacesMessage("String input",
                            "Provide a number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }
        if (!flag) {
            if (amt <= 0) {
                FacesMessage msg =
                        new FacesMessage("Deposits are positive and greater than zero",
                                "Invalid amount.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }
}
