package Cloud.model;

import java.util.Objects;

public class ComputeEngine {

    private String numberOfInstances;
    private String operatingSystem;
    private String vmClass;
    private String seriesOfInstanceType;
    private String instanceType;
    private String numberOfGPUs;
    private String gpuType;
    private String ssd;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEngine(String numberOfInstances, String operatingSystem, String vmClass,
                         String seriesOfInstanceType, String instanceType, String numberOfGPUs, String gpuType,
                         String ssd, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.operatingSystem = operatingSystem;
        this.vmClass = vmClass;
        this.seriesOfInstanceType = seriesOfInstanceType;
        this.instanceType = instanceType;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.ssd = ssd;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getVmClass() {
        return vmClass;
    }

    public String getSeriesOfInstanceType() {
        return seriesOfInstanceType;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getSsd() {
        return ssd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", seriesOfInstanceType='" + seriesOfInstanceType + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", ssd='" + ssd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeEngine that = (ComputeEngine) o;
        return Objects.equals(numberOfInstances, that.numberOfInstances) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(vmClass, that.vmClass) &&
                Objects.equals(seriesOfInstanceType, that.seriesOfInstanceType) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(numberOfGPUs, that.numberOfGPUs) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(ssd, that.ssd) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(committedUsage, that.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, vmClass, seriesOfInstanceType, instanceType,
                numberOfGPUs, gpuType, ssd, datacenterLocation, committedUsage);
    }
}
