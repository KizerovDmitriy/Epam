package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private int emailCounter = 0;
    private int socialCounter = 0;
    private final ContactInfo[] contactInfo = new ContactInfo[11];

    public Contact(String contactName) {
        this.contactName = contactName;
        contactInfo[0] = new NameContactInfo();
    }

    private class NameContactInfo implements ContactInfo {
        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public void rename(String newName) {
        if (newName != null && newName.length() != 0) {
            this.contactName = newName;
        }
    }

    public static class Email implements ContactInfo {
        String localParts;
        String domain;

        public Email(String localParts, String domain) {
            this.localParts = localParts;
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localParts + "@" + domain;
        }
    }

    public Email addEmail(String localPart, String domain) {
        if (emailCounter < 3) {
            Email email = new Email(localPart, domain);
            contactInfo[emailCounter + 2] = email;
            emailCounter++;
            return email;
        }
        return null;
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (emailCounter < 3) {
            Email epamEmail = new Email(firstname, lastname) {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }

                @Override
                public String getValue() {
                    return firstname + "_" + lastname + "@epam.com";
                }
            };
            contactInfo[emailCounter + 2] = epamEmail;
            emailCounter++;
            return epamEmail;
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (contactInfo[1] == null) {
            ContactInfo phoneNumber = new NameContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            contactInfo[1] = phoneNumber;
            return phoneNumber;
        }
        return null;
    }

    public static class Social implements ContactInfo {
        String title;
        String id;

        public Social(String title, String id) {
            this.title = title;
            this.id = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }

    public Social addTwitter(String twitterId) {
        if (socialCounter < 5) {
            Social social = new Social("Twitter",twitterId);
            contactInfo [socialCounter + 5] = social;
            socialCounter++;
            return social;
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        if (socialCounter < 5) {
            Social social = new Social("Instagram",instagramId);
            contactInfo [socialCounter + 5] = social;
            socialCounter++;
            return social;
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        if (socialCounter < 5) {
            Social social = new Social(title,id);
            contactInfo [socialCounter + 5] = social;
            socialCounter++;
            return social;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        ContactInfo[] tmp = new ContactInfo[11];
        int realLength = 0;
        for (int i = 0; i < tmp.length - 1; i++) {
            if (contactInfo[i] != null) {
                tmp[realLength] = contactInfo[i];
                realLength++;
            }
        }
        ContactInfo[] result = new ContactInfo[realLength];
        System.arraycopy(tmp, 0, result, 0, realLength);
        return result;
    }
}