public class SavingsAccount_S2023_Group6 extends BankAccount_S2023_Group6 {
  private String savingAccountNum;
  private double accountBalance;

  public SavingsAccount_S2023_Group6(String savingAccountNum, double accountBalance) {
    this.savingAccountNum = savingAccountNum;
    this.accountBalance = accountBalance;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  @Override /** Return area */
  public double getArea() {
    return width * height;
  }

  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }
}
