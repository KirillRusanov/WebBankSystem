package banksystem.web.dto;

public class CountDTO {

        private Long id;
        private String number;
        private Integer balance;
        private String currency;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNumber() {
                return number;
        }

        public void setNumber(String number) {
                this.number = number;
        }

        public Integer getBalance() {
                return balance;
        }

        public void setBalance(Integer balance) {
                this.balance = balance;
        }

        public String getCurrency() {
                return currency;
        }

        public void setCurrency(String currency) {
                this.currency = currency;
        }
}
