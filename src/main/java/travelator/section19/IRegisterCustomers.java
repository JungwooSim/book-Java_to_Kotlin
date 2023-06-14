package travelator.section19;

import travelator.section19.handlers.RegistrationData;

public interface IRegisterCustomers {
    Customer register(RegistrationData data)
            throws ExcludedException, DuplicateException;
}