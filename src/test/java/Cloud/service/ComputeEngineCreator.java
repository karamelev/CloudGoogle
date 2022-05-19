package Cloud.service;

import Cloud.model.ComputeEngine;

public class ComputeEngineCreator {

    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.computeEngine.numberOfInstances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.computeEngine.operatingSystem";
    public static final String TESTDATA_VM_CLASS = "testdata.computeEngine.vmClass";
    public static final String TESTDATA_SERIES_OF_INSTANCE_TYPE = "testdata.computeEngine.seriesOfInstanceType";
    public static final String TESTDATA_INSTANCE_TYPE = "testdata.computeEngine.instanceType";
    public static final String TESTDATA_NUMBER_OF_GPU = "testdata.computeEngine.numberOfGPUs";
    public static final String TESTDATA_GPU_TYPE = "testdata.computeEngine.gpuType";
    public static final String TESTDATA_SSD = "testdata.computeEngine.ssd";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.computeEngine.datacenterLocation";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.computeEngine.committedUsage";

    public static ComputeEngine withOptionsFromProperty(){
        return new ComputeEngine(
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_VM_CLASS),
                TestDataReader.getTestData(TESTDATA_SERIES_OF_INSTANCE_TYPE),
                TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPU),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE));
    }
}
