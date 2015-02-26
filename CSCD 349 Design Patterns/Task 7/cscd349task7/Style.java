public class Style {   
   
   boolean isBold = false;
   boolean isItalic = false;
   boolean isUnderline = false;
   
   public Style() {}
   
   public Style(boolean isBold, boolean isItalic, boolean isUnderline) {
   
      this.isBold = isBold;
      this.isItalic = isItalic;
      this.isUnderline = isUnderline;
   }
   
   public String generateTagClose() {
   
      String tagClose = "";
   
      if(isBold) {
      
         tagClose += "</B>";
      }
      if(isItalic) {
      
         tagClose += "</I>";
      }
      if(isUnderline) {
      
         tagClose += "</U>";
      }
   
      return tagClose;
   }
   
   public String generateTagOpen() {
   
      String tagOpen = "";
   
      if(isBold) {
      
         tagOpen = "<B>" + tagOpen;
      }
      if(isItalic) {
      
         tagOpen = "<I>" + tagOpen;
      }
      if(isUnderline) {
      
         tagOpen = "<U>" + tagOpen;
      }
   
      return tagOpen;
   }
   
   public void intersect(Style style) {
   
      if(isBold && style.isBold());
      else
         isBold = false;
         
      if(isItalic && style.isItalic());
      else
         isItalic = false;
         
      if(isUnderline && style.isUnderline());
      else
         isUnderline = false;
   }
   
   public boolean isBold() {
   
      return isBold;
   }
   
   public void isBold(boolean isBold) {
   
      this.isBold = isBold;
   }
   
   public boolean isItalic() {
   
      return isItalic;
   }
   
   public void isItalic(boolean isItalic) {
   
      this.isItalic = isItalic;
   }
   
   public boolean isUnderline() {
   
      return isUnderline;
   }
   
   public void isUnderline(boolean isUnderline) {
   
      this.isUnderline = isUnderline;
   }
   
   @Override 
   public String toString() {
   
      return "Style{isBold=" + isBold + " isItalic=" + isItalic + " isUnderline=" + isUnderline + "}";
   }
   
   public void union(Style style) {
   
      if(isBold || style.isBold())
         isBold = true;
         
      if(isItalic || style.isItalic())
         isItalic = true;
         
      if(isUnderline || style.isUnderline())
         isUnderline = true;
   }
}