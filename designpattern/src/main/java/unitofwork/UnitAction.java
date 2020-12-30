package unitofwork;

public enum UnitAction {
  INSERT("INSERT"),
  DELETE("DELETE"),
  MODIFY("MODIFY");
  private final String actionValue;

  UnitAction(String actionValue) {
    this.actionValue = actionValue;
  }

  public String getActionValue() {
    return actionValue;
  }
}
