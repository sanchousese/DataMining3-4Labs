import weka.classifiers.meta.RegressionByDiscretization;
import weka.classifiers.trees.J48graft;
import weka.classifiers.trees.LADTree;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by sancho on 26.04.15.
 */
public class Main4lab {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new FileReader("data/boobs_dataset_for_trees.arff"));   // Тут змінити на файл з даними
        Instances data = new Instances(reader);
        reader.close();
        data.setClassIndex(data.numAttributes() - 1);

//        LADTree model = new LADTree();                          // Сутула
        J48graft model = new J48graft();                        // Круш, Михалько

        model.buildClassifier(data);

        System.out.println(model);
        System.out.println();
    }
}
