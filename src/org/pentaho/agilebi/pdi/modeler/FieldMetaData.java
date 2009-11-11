package org.pentaho.agilebi.pdi.modeler;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.pentaho.metadata.model.LogicalColumn;
import org.pentaho.ui.xul.XulEventSourceAdapter;

/**
 * @author wseyler
 *
 */
public class FieldMetaData extends XulEventSourceAdapter {
  String rowNum;
  String fieldName;
  String format;
  String displayName;
  String fieldTypeDesc = "---";
  String levelTypeDesc = "---";
  String aggTypeDesc = "---";
  LogicalColumn logicalColumn;

  public FieldMetaData(){
    
  }
  
  public FieldMetaData(String rowNum, String fieldName, String format, String displayName, String fieldTypeDesc, String levelTypeDesc, String aggTypeDesc) {
    super();
    this.rowNum = rowNum;
    this.fieldName = fieldName;
    this.format = format;
    this.displayName = displayName;
    this.fieldTypeDesc = fieldTypeDesc;
    this.levelTypeDesc = levelTypeDesc;
    this.aggTypeDesc = aggTypeDesc;
  }

  public String getRowNum() {
    return rowNum;
  }

  public void setRowNum(String rowNum) {
    this.rowNum = rowNum;
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getFieldTypeDesc() {
    return fieldTypeDesc;
  }

  public void setFieldTypeDesc(String fieldTypeDesc) {
    this.fieldTypeDesc = fieldTypeDesc;
  }

  public String getLevelTypeDesc() {
    return levelTypeDesc;
  }

  public void setLevelTypeDesc(String levelTypeDesc) {
    this.levelTypeDesc = levelTypeDesc;
  }

  public String getAggTypeDesc() {
    return aggTypeDesc;
  }

  public void setAggTypeDesc(String aggTypeDesc) {
    this.aggTypeDesc = aggTypeDesc;
  }
  
  // TODO: generate this based on field type
  public Vector<String> getAggTypeDescValues() {
    List<String> li = new ArrayList<String>();
    li.add("SUM");
    li.add("MIN");
    li.add("MAX");
    return new Vector(li);
  }
  
  public LogicalColumn getLogicalColumn(){
    return logicalColumn;
  }
  public void setLogicalColumn(LogicalColumn col){
    this.logicalColumn = col;
  }
  
}