/*!
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
* Foundation.
*
* You should have received a copy of the GNU Lesser General Public License along with this
* program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
* or from the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU Lesser General Public License for more details.
*
* Copyright (c) 2002-2017 Hitachi Vantara..  All rights reserved.
*/

package org.pentaho.agilebi.spoon;

import org.pentaho.di.i18n.BaseMessages;

import java.util.Enumeration;
import java.util.ResourceBundle;


public class PDIMessages extends ResourceBundle{

  private static ResourceBundle lafBundle;
  private Class clz = this.getClass();
  
  public PDIMessages(){
  }
  
  public PDIMessages(Class pkg){
    this.clz = pkg;
  }
  
  @Override
  public Enumeration<String> getKeys() {
    return null;
  }

  @Override
  protected Object handleGetObject(String key) {
    String result = BaseMessages.getString(clz, key);
    return result;
  }
  
}
