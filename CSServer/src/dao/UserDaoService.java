

/**
 * UserDaoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.2  Built on : May 02, 2016 (05:55:18 BST)
 */

    package dao;

    /*
     *  UserDaoService java interface
     */

    public interface UserDaoService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getUserById0
                
         */

         
                     public dao.GetUserByIdResponse getUserById(

                        dao.GetUserById getUserById0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserById0
            
          */
        public void startgetUserById(

            dao.GetUserById getUserById0,

            final dao.UserDaoServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param login2
                
         */

         
                     public dao.LoginResponse login(

                        dao.Login login2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param login2
            
          */
        public void startlogin(

            dao.Login login2,

            final dao.UserDaoServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUserImg4
                
         */

         
                     public dao.UpdateUserImgResponse updateUserImg(

                        dao.UpdateUserImg updateUserImg4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUserImg4
            
          */
        public void startupdateUserImg(

            dao.UpdateUserImg updateUserImg4,

            final dao.UserDaoServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param register6
                
         */

         
                     public dao.RegisterResponse register(

                        dao.Register register6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param register6
            
          */
        public void startregister(

            dao.Register register6,

            final dao.UserDaoServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    