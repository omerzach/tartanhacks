
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.Configurable;

public class ConfigManager {
  private ConfigurationManager mine;

  public ConfigManager(String str) {
    this.mine = new ConfigurationManager(str);
  }

  public Configurable lookup(java.lang.String instanceName) {
    return mine.lookup(instanceName);
  }
}

