import weka.classifiers.trees.J48graft;
import weka.clusterers.FarthestFirst;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by sancho on 27.04.15.
 */
public class Main4labCluster {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(
                new FileReader("data/boobs_dataset_1.arff"));   // Тут змінити на файл з даними
        Instances data = new Instances(reader);
        reader.close();

        FarthestFirst model = new FarthestFirst();

        model.buildClusterer(data);

        System.out.println(model);
        System.out.println();
    }
}
