package org.pentaho.agilebi.pdi.modeler;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.pentaho.ui.xul.util.AbstractModelNode;

public abstract class AbstractMetaDataModelNode<T extends AbstractMetaDataModelNode> extends AbstractModelNode<T> {

  private static final long serialVersionUID = 1547202580713108254L;

  protected boolean valid = true;
  protected List<String> validationMessages = new ArrayList<String>();
  protected String image;
  
  protected PropertyChangeListener validListener = new PropertyChangeListener(){
    public void propertyChange(PropertyChangeEvent arg0) {
      validateNode();
    }
  };

  protected PropertyChangeListener nameListener = new PropertyChangeListener(){
    public void propertyChange(PropertyChangeEvent arg0) {
      validateNode();
    }
  };
  
  protected transient PropertyChangeListener childrenListener = new PropertyChangeListener(){
    public void propertyChange(PropertyChangeEvent evt) {
      fireCollectionChanged();
    }
  };
  
  public AbstractMetaDataModelNode() {
    this.image = getValidImage();
  }
  

  @Override
  public void onAdd(T child) {
    child.addPropertyChangeListener("name", nameListener);
    child.addPropertyChangeListener("valid", validListener);
    child.addPropertyChangeListener("children", childrenListener);
    validateNode();
  }

  @Override
  public void onRemove(T child) {
    child.removePropertyChangeListener(validListener);
    child.removePropertyChangeListener(nameListener);
    child.removePropertyChangeListener(childrenListener);
    validateNode();
  }
  
  public String getValidationMessagesString() {
    String str = ""; //$NON-NLS-1$
    for (int i = 0 ; i < validationMessages.size(); i++) {
      if (i > 0) {
        str += ", "; //$NON-NLS-1$
      } 
      str += validationMessages.get(i);
    }
    return str;
  }
  
  public List<String> getValidationMessages() {
    return validationMessages; 
  }
  
  @Override
  protected void fireCollectionChanged() {
    super.fireCollectionChanged();
    validateNode();
  }
  
  public void setImage(String image) {
    if (this.image == null || !this.image.equals(image)) {
      String oldimg = this.image;
      this.image = image;
      this.firePropertyChange("image", oldimg, image); //$NON-NLS-1$
    }
  }
  
  public abstract String getValidImage();
  
  public final String getInvalidImage() {
    return "images/warning.png"; //$NON-NLS-1$
  }  
  public String getImage() {
    return (this.valid)? getValidImage():getInvalidImage();
  }
  
  public abstract void validate();
  
  public void validateNode() {
    boolean prevValid = valid;
    String prevMessages = getValidationMessagesString();
    validate();
    this.firePropertyChange("valid", prevValid, valid);
    this.firePropertyChange("validationMessagesString", prevMessages, getValidationMessagesString());
    if (valid) {
      setImage(getValidImage());
    } else {
      setImage(getInvalidImage());
    }
  }
  
  
  @SuppressWarnings("unchecked")
  public void validateTree() {
    for (T t : this) {
      ((AbstractMetaDataModelNode)t).validateTree();
    }
    validateNode();
  };
  
  @SuppressWarnings("unchecked")
  public boolean isTreeValid() {
    if (!isValid()) {
      return false;
    }
    for (T t : this) {
      if (!((AbstractMetaDataModelNode)t).isValid()) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isValid() {
    return valid;
  }
  
  
  public abstract Class<? extends ModelerNodePropertiesForm> getPropertiesForm();
  
}