
/**
 * SceneryDaoServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.2  Built on : May 02, 2016 (05:55:18 BST)
 */

    package dao;

    /**
     *  SceneryDaoServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class SceneryDaoServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public SceneryDaoServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public SceneryDaoServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getSceneryWithInfoById method
            * override this method for handling normal response from getSceneryWithInfoById operation
            */
           public void receiveResultgetSceneryWithInfoById(
                    dao.GetSceneryWithInfoByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSceneryWithInfoById operation
           */
            public void receiveErrorgetSceneryWithInfoById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteOperation method
            * override this method for handling normal response from deleteOperation operation
            */
           public void receiveResultdeleteOperation(
                    dao.DeleteOperationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteOperation operation
           */
            public void receiveErrordeleteOperation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addOperationByIds method
            * override this method for handling normal response from addOperationByIds operation
            */
           public void receiveResultaddOperationByIds(
                    dao.AddOperationByIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addOperationByIds operation
           */
            public void receiveErroraddOperationByIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSceneryListWithInfo method
            * override this method for handling normal response from getSceneryListWithInfo operation
            */
           public void receiveResultgetSceneryListWithInfo(
                    dao.GetSceneryListWithInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSceneryListWithInfo operation
           */
            public void receiveErrorgetSceneryListWithInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHistoryListByUserId method
            * override this method for handling normal response from getHistoryListByUserId operation
            */
           public void receiveResultgetHistoryListByUserId(
                    dao.GetHistoryListByUserIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHistoryListByUserId operation
           */
            public void receiveErrorgetHistoryListByUserId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSceneryById method
            * override this method for handling normal response from getSceneryById operation
            */
           public void receiveResultgetSceneryById(
                    dao.GetSceneryByIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSceneryById operation
           */
            public void receiveErrorgetSceneryById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addHistory method
            * override this method for handling normal response from addHistory operation
            */
           public void receiveResultaddHistory(
                    dao.AddHistoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addHistory operation
           */
            public void receiveErroraddHistory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNumberOfOperation method
            * override this method for handling normal response from getNumberOfOperation operation
            */
           public void receiveResultgetNumberOfOperation(
                    dao.GetNumberOfOperationResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNumberOfOperation operation
           */
            public void receiveErrorgetNumberOfOperation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateSceneryIcons method
            * override this method for handling normal response from updateSceneryIcons operation
            */
           public void receiveResultupdateSceneryIcons(
                    dao.UpdateSceneryIconsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateSceneryIcons operation
           */
            public void receiveErrorupdateSceneryIcons(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getScoresBySceneryId method
            * override this method for handling normal response from getScoresBySceneryId operation
            */
           public void receiveResultgetScoresBySceneryId(
                    dao.GetScoresBySceneryIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getScoresBySceneryId operation
           */
            public void receiveErrorgetScoresBySceneryId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCommentListBySceneryId method
            * override this method for handling normal response from getCommentListBySceneryId operation
            */
           public void receiveResultgetCommentListBySceneryId(
                    dao.GetCommentListBySceneryIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCommentListBySceneryId operation
           */
            public void receiveErrorgetCommentListBySceneryId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMediaBySceneryId method
            * override this method for handling normal response from getMediaBySceneryId operation
            */
           public void receiveResultgetMediaBySceneryId(
                    dao.GetMediaBySceneryIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMediaBySceneryId operation
           */
            public void receiveErrorgetMediaBySceneryId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addComment method
            * override this method for handling normal response from addComment operation
            */
           public void receiveResultaddComment(
                    dao.AddCommentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addComment operation
           */
            public void receiveErroraddComment(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSceneryList method
            * override this method for handling normal response from getSceneryList operation
            */
           public void receiveResultgetSceneryList(
                    dao.GetSceneryListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSceneryList operation
           */
            public void receiveErrorgetSceneryList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSceneryListByOp method
            * override this method for handling normal response from getSceneryListByOp operation
            */
           public void receiveResultgetSceneryListByOp(
                    dao.GetSceneryListByOpResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSceneryListByOp operation
           */
            public void receiveErrorgetSceneryListByOp(java.lang.Exception e) {
            }
                


    }
    