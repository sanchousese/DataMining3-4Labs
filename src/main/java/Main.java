import weka.classifiers.functions.SMOreg;
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
        Instances data = new Instances(new BufferedReader(
                new FileReader("/home/sancho/IdeaProjects/work/untitled3/bmw-test.arff")));
        data.setClassIndex(data.numAttributes() - 2);

        SMOreg model = new SMOreg();
        model.buildClassifier(data);

        System.out.println(model);

        Instance myBMW = data.lastInstance();
        double purchase = model.classifyInstance(myBMW);

        System.out.println(myBMW + " " + purchase);

    }
}
