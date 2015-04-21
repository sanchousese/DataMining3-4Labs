import weka.classifiers.functions.LinearRegression;
import weka.classifiers.meta.RegressionByDiscretization;
import weka.core.Instance;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by sancho on 21.04.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new FileReader("/home/sancho/IdeaProjects/work/untitled3/data/boobs_dataset_1.arff"));   //Тут змінити на файл з даними
        Instances data = new Instances(reader);
        reader.close();
        data.setClassIndex(data.numAttributes() - 1);


        LinearRegression model = new LinearRegression();                        //Михалько
//        RegressionByDiscretization model = new RegressionByDiscretization();  // Круш

        model.buildClassifier(data);

        System.out.println(model);
        System.out.println();

//        Instance myBMW = data.lastInstance();
        Instance girl = new Instance(2);
        girl.setValue(0, 50);
        double purchase = model.classifyInstance(girl);

        System.out.println(girl + " " + purchase);

    }
}
