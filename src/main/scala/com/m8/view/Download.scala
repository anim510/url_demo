package com.m8.view

import _root_.net.liftweb._
import http._
import S._
import _root_.net.liftweb.util._
import Helpers._
import scala.xml.{NodeSeq, Text, Unparsed}


class Download extends LiftView {
	override def dispatch = {
		case _ => doShow _
	}
	
	def doShow():NodeSeq = {
	  val link = S.param("link").openOr("")
Log.info("11111111  : " + link)
Log.info("22222222  : " + Helpers.urlDecode(link) )

    // 1: 
    // This url is sent from client:
    // http://localhost:8080/download.html?link=http://localhost:3000/files/≤‚ ‘.rar&12345678
    
    // 2:
    // And get these result: (contains the "???rar" chars, not "≤‚ ‘.rar",  and the "12345678" was lost!)
    // INFO - 11111111  : http://localhost:3000/files/???rar
    // INFO - 22222222  : http://localhost:3000/files/???rar
    
    // 3:
    // I want this string "http://localhost:3000/files/≤‚ ‘.rar&12345678"
    // was shown on the page, but the result is : "http://localhost:3000/files/???rar"
  
		<lift:surround with="default" at="content">
		  {link}
		</lift:surround>
	}

} 
