package preo.mcrl2

import org.junit.Assert._
import org.junit.Test
import preo.frontend.mcrl2._

class TestAtom {
  @Test
  def testAction(): Unit ={
    //assert Prints
    assertEquals(Action("X",In(1),Some(1) ).toString , "X_1i1")
    assertEquals(Action("X", In(2), Some(1)).toString , "X_1i2")
    assertEquals(Action("X", Out(1), Some(1)).toString , "X_1o1")
    assertEquals(Action("X", Out(2), Some(1)).toString , "X_1o2")
    assertEquals(Action.nullAction.toString , "Null")
    assertEquals(Action("X", Nothing, Some(1)).toString , "X_1")
    //assert Equals
    assertNotEquals(Action("X", Out(2), Some(1)), Action("X", Out(1), Some(1)))
    assertEquals(Action("Null", Nothing, None), Action.nullAction)
  }

  @Test
  def testMultiAction(): Unit={
    //assert prints for 0, 1 and 2 Actions
    assertEquals(MultiAction().toString, "Null")
    assertEquals(MultiAction(Action("X", Nothing, Some(1))).toString, Action("X", Nothing, Some(1)).toString)
    assertEquals(MultiAction(Action("X", Nothing, Some(1)), Action("X", In(1), Some(2))).toString, s"${Action("X", Nothing, Some(1)).toString} | ${Action("X", In(1), Some(2)).toString}")
  }

}
