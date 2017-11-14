package androidclient.meritlist.in.meritlist.interfaces;

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;

import androidclient.meritlist.in.meritlist.models.NameInfo;
import androidclient.meritlist.in.meritlist.models.RequestClass;
import androidclient.meritlist.in.meritlist.models.ResponseClass;

/**
 * Created by rmammadov on 6/2/16.
 */
public interface MyInterface {

    /**
     * Invoke the Lambda function "AndroidBackendLambdaFunction".
     * The function name is the method name.
     */
    @LambdaFunction
    String helloworld(NameInfo nameInfo);
}
