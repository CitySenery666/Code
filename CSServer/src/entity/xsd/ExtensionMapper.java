
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.2  Built on : May 02, 2016 (05:56:08 BST)
 */

        
            package entity.xsd;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://entity/xsd".equals(namespaceURI) &&
                  "SceneryWithInfo".equals(typeName)){
                   
                            return  entity.xsd.SceneryWithInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://entity/xsd".equals(namespaceURI) &&
                  "Media".equals(typeName)){
                   
                            return  entity.xsd.Media.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://entity/xsd".equals(namespaceURI) &&
                  "CommentofUser".equals(typeName)){
                   
                            return  entity.xsd.CommentofUser.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://entity/xsd".equals(namespaceURI) &&
                  "Scenery".equals(typeName)){
                   
                            return  entity.xsd.Scenery.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://entity/xsd".equals(namespaceURI) &&
                  "User".equals(typeName)){
                   
                            return  entity.xsd.User.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    