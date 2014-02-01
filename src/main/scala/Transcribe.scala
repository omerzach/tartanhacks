
import edu.cmu.sphinx.frontend.util.AudioFileDataSource
import edu.cmu.sphinx.linguist.language.grammar.TextAlignerGrammar
import edu.cmu.sphinx.recognizer.Recognizer
import edu.cmu.sphinx.result.Result
import edu.cmu.sphinx.util.props.ConfigurationManager
import java.io.File
import java.net.URL
import scala.annotation.tailrec

object Transcriber {
  def main(args: Array[String]) = {
    if (args.length < 1) {
      println("Need more arguments");
      // TODO: Exit
    }

    val configManager: ConfigManager = new ConfigManager(args(0))
    println(args(0))
 
    val grammar: TextAlignerGrammar = configManager.lookup("textAlignGrammar").asInstanceOf[TextAlignerGrammar]
    grammar.setText("hello world")

    val recognizer: Recognizer = configManager.lookup("recognizer").asInstanceOf[Recognizer]
    recognizer.addResultListener(grammar)
    recognizer.allocate

    val dataSource: AudioFileDataSource = configManager.lookup("audioFileDataSource").asInstanceOf[AudioFileDataSource]
    println(new URL("file:/Users/omerzach/Dropbox/tartanhacks/resources/10001-90210-01803.wav"))
    dataSource.setAudioFile(new URL("file:/Users/omerzach/Dropbox/tartanhacks/resources/10001-90210-01803.wav"), null)

/*
    var result: Result = null

    @tailrec 
    def outputResults(): Unit = {
      val result: Result = recognizer.recognize
      if (result == null) {
        return
      } else {
        println(result.getTimedBestResult(false, true))
        outputResults()
      }
    }

    outputResults()
*/

    println("Testing")
  }
}

