
import edu.cmu.sphinx.frontend.util.AudioFileDataSource
import edu.cmu.sphinx.linguist.language.grammar.TextAlignerGrammar
import edu.cmu.sphinx.recognizer.Recognizer
import edu.cmu.sphinx.result.Result
import edu.cmu.sphinx.util.props.ConfigurationManager
import java.net.URL
import scala.annotation.tailrec

object Transcriber {
  def main(args: Array[String]) = {
    if (args.length < 1) {
      println("Need more arguments");
      // TODO: Exit
    }

    val configManager = new ConfigurationManager(args(0))
    println(args(0))
 
    //val grammar: TextAlignerGrammar = new TextAlignerGrammar
    val x: java.lang.String = "textAlignGrammar"
    val grammar: TextAlignerGrammar = configManager.lookup(x)//"textAlignGrammar"/*classOf[TextAlignerGrammar]*/)
    //println(grammar)
    grammar.setText("hello world")

    val recognizer: Recognizer = new Recognizer //configManager.lookup(classOf[Recognizer])
    recognizer.addResultListener(grammar)
    recognizer.allocate

    val dataSource: AudioFileDataSource = configManager.lookup(classOf[AudioFileDataSource]);
    dataSource.setAudioFile(new URL("file:resources/hello-world.wav"), null);

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

    println("Testing")
  }
}

