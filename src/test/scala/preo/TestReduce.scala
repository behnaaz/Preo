package preo

import org.scalatest.FlatSpec
import preo.DSL._
import preo.ast.Connector
import preo.examples.Repository.{seqfifo, sequencer, zip}
import preo.frontend.{Eval, Show}

/**
  * Created by jose on 14/03/16.
  */
class TestReduce extends FlatSpec {

  val x: I = "x"
  val y: I = "y"
  val n: I = "n"



  testOK(fifo ^ 3, "fifo ⊗ (fifo ⊗ fifo)")
  testOK(seqfifo,"fifo")
  //    testOK(zip,"Id(2)")
  testOK(zip(1),"Id(2)")
  testOK(lam(n,lam(x,id^x)),"id")
  testOK(lam(x,id^x) & lam(y,id^y),"nil")
  testOK(lam(n,lam(x,id^x) & lam(y,id^y)),"nil")
//  testOK(sequencer,"(dupl ⊗ Tr(1)(fifofull ; dupl)) ; (id ⊗ drain)")
  // (dupl ⊗ Tr_1{fifo ; dupl}) ; (id ⊗ drain)
  testOK(sequencer,"(((dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ (dupl ⊗ dupl))))))))))))))))))))) ; loop(924)((id ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(3) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(5) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(7) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(9) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(11) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(13) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(15) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(17) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(19) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(21) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(23) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(25) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(27) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(29) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(31) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(33) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(35) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(37) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(39) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(41) ⊗ (sym(1,1) ⊗ Id(65))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))) ; sym(924,44))) ⊗ loop(22)((sym(21,1) ; ((fifofull ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ ((fifo ; dupl) ⊗ (fifo ; dupl))))))))))))))))))))))) ; loop(924)((id ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(3) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(5) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(7) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(9) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(11) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(13) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(15) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(17) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(19) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(21) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(23) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(25) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(27) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(29) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(31) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(33) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(35) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(37) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(39) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(41) ⊗ (sym(1,1) ⊗ Id(65))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))) ; sym(924,44)))) ; (Id(22) ⊗ (loop(924)((Id(65) ⊗ (sym(1,1) ⊗ (Id(41) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(39) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(37) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(35) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(33) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(31) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(29) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(27) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(25) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(23) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(21) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(19) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(17) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(15) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(13) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(11) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(9) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(7) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(5) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (Id(3) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ (sym(1,1) ⊗ id)))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))))) ; sym(924,44)) ; (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ (drain ⊗ drain)))))))))))))))))))))))")


  testInstOK(lam(x,id^x) & lam(y,id^y),"((\\x:I.(id^x)) ; (\\y:I.(id^y)))(0)(0)")
  testInstOK(lam(n,lam(x,id^x) & lam(y,id^y)),"(\\n:I.((\\x:I.(id^x)) ; (\\y:I.(id^y))))(1)(0)(0)")


  private def testOK(con:Connector,str:String) = {
    val c = Eval.reduce(con)
    s"Connector ${Show(con)}" should s"be reduced to $str" in
      assertResult(str)(Show(c))
  }

  private def testInstOK(con:Connector,str:String) = {
    val c = Eval.instantiate(con)
    s"Connector ${Show(con)}" should s"instantiate to $str" in {
      assert(typeCheck(c).isDefined)
      assertResult(str)(Show(c))
    }
  }

}
