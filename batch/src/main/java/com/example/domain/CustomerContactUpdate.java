package com.example.domain;

import org.springframework.util.StringUtils;

public class CustomerContactUpdate extends CustomerUpdate{

    private final String emailAddress;
    private final String homePhone;
    private final String cellPhone;
    private final String workPhone;
    private final String notificationPreferences;

    public CustomerContactUpdate(Long customerId, String emailAddress, String homePhone, String cellPhone, String workPhone, String notificationPreferences) {
        super(customerId);
        this.emailAddress = StringUtils.hasText(emailAddress) ? emailAddress : null;
        this.homePhone = StringUtils.hasText(homePhone) ? homePhone : null;
        this.cellPhone = StringUtils.hasText(cellPhone) ? cellPhone : null;
        this.workPhone = StringUtils.hasText(workPhone) ? workPhone : null;
        this.notificationPreferences = notificationPreferences;
    }
}
