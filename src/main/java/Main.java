import weka.classifiers.functions.IsotonicRegression;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.meta.RegressionByDiscretization;
import weka.core.Instance;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by sancho on 21.04.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new FileReader("../untitled3/bmw-test.arff"));   //Тут змінити на файл з даними
        Instances data = new Instances(reader);
        reader.close();
        data.setClassIndex(data.numAttributes() - 2);


        LinearRegression model = new LinearRegression();                        //Михалько
//        RegressionByDiscretization model = new RegressionByDiscretization();   // Круш

        model.buildClassifier(data);

        System.out.println(model);

        Instance myBMW = data.lastInstance();
        double purchase = model.classifyInstance(myBMW);

        System.out.println(myBMW + " " + purchase);

    }
}
