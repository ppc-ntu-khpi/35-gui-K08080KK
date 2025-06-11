package domain;

import com.mybank.domain.*;

public class Report {

  public Report() {
  }

  public String generateReport() {
    StringBuilder report = new StringBuilder();

    
    report.append("\t\t\tCUSTOMERS REPORT\n");
    report.append("\t\t\t================\n");

    
    for (int cust_idx = 0; cust_idx < Bank.getNumberOfCustomers(); cust_idx++) {
      Customer customer = Bank.getCustomer(cust_idx);

      
      report.append("\nCustomer: ")
            .append(customer.getLastName())
            .append(", ")
            .append(customer.getFirstName())
            .append("\n");

    
      for (int acct_idx = 0; acct_idx < customer.getNumberOfAccounts(); acct_idx++) {
        Account account = customer.getAccount(acct_idx);
        String account_type;

        
        if (account instanceof SavingsAccount) {
          account_type = "Savings Account";
        } else if (account instanceof CheckingAccount) {
          account_type = "Checking Account";
        } else {
          account_type = "Unknown Account Type";
        }

        
        report.append("    ")
              .append(account_type)
              .append(": current balance is ")
              .append(account.getBalance())
              .append("\n");
      }
    }

    return report.toString();
  }
}
