import java.io.File
import java.io.PrintWriter

object myPrintWriter {

  val assertionsEnabled = false

  def withOldPrintWriter(file: File, op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def boolAssert(predicate: Boolean) {
    if(assertionsEnabled && !predicate)
      throw new AssertionError
  }
}
