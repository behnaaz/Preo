package preo.modelling

abstract class Mcrl2Process{
  def vars: List[Action]

  def toString: String
}





/**
  * the sequence operator in mcrl2 (before . after) when printed
  * @param before before process
  * @param after after process
  */
case class Seq(before: Mcrl2Process, after: Mcrl2Process) extends Mcrl2Process{
  override def toString: String = s"(${before.toString}) . (${after.toString})"

  override def vars: List[Action] = before.vars ++ after.vars
}


/**
  * the choice operator in mcrl2 (left + right) when printed
  * @param left left process
  * @param right right process
  */
case class Choice(left: Mcrl2Process, right: Mcrl2Process) extends Mcrl2Process{
  override def toString: String = s"(${left.toString}) + (${right.toString})"

  override def vars: List[Action] = left.vars ++ right.vars
}


/**
  * the paralel operator in mcrl2 (left || right) when printed
  * @param left left process
  * @param right right process
  */
case class Par(left: Mcrl2Process, right:Mcrl2Process) extends Mcrl2Process{
  override def toString: String = s"(${left.toString}) || (${right.toString})"

  override def vars: List[Action] = left.vars ++ right.vars
}

/**
  * creates a communication operator with the 3 actions in the tuple in the process
  * @param actions the actions to communicate
  * @param in the process where the communication will happen
  */
case class Comm(actions: (Action, Action, Action), in: Mcrl2Process) extends Mcrl2Process{
  override def toString: String = s"""comm({${toString(actions)}}, ${in.toString})"""

  def toString(vars: (Action, Action, Action)): String = s"""${vars._1.toString}|${vars._2.toString} -> ${vars._3.toString}"""

  override def vars: List[Action] = actions._1 :: in.vars
}

/**
  * The allow operator in mcrl2
  * @param actions actions allowed
  * @param in process where the actions are allowed
  */
case class Allow(actions: List[Action], in: Mcrl2Process) extends Mcrl2Process{
  override def toString: String = s"""allow({${Mcrl2Def.toString(actions)}}, ${in.toString})"""

  override def vars: List[Action] = in.vars
}

/**
  * the block operator in mcrl2
  * @param actions the blocked actions
  * @param in the process where the actions are blocked
  */
case class Block(actions: List[Action], in: Mcrl2Process) extends Mcrl2Process{
  override def toString: String = s"""block({${Mcrl2Def.toString(actions)}}, ${in.toString})"""

  override def vars: List[Action] = in.vars
}

/**
  * the hide operator in mcrl2
  * @param actions the actions to be hidden
  * @param in the process where the actions are hidden
  */
case class Hide(actions: List[Action], in: Mcrl2Process) extends Mcrl2Process{
  override def toString: String = s"""hide({${Mcrl2Def.toString(actions)}}, ${in.toString})"""

  override def vars: List[Action] = in.vars
}