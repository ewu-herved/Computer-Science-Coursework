public class LinkStyled {

   private Link link;
   
   private Style style;
   
   public LinkStyled(Link link) {
   
      if(link == null)
         throw new NullPointerException("Null passed in for link\n");
      
      this.link = link;
      
      style = new Style();
   }
   
   public LinkStyled(Link link, Style style) {
   
      if(link == null)
         throw new NullPointerException("Null passed in for link\n");
         
      if(style == null)
         throw new NullPointerException("Null passed in for style\n");
      
      this.link = link;
      
      this.style = style;
   }
   
   public Link getLink() {
   
      return link;
   }
   
   public Style getStyle() {
   
      return style;
   }
   
   @Override
   public String toString() {
   
      return "LinkStyled{link=" + link + " style=" + style + "}";
   }
}