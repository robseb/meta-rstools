# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to write to any HPS-FPGA Bridge address" 
SECTION = "rstools" 
LICENSE = "OPEN" 
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=a60433f145375b57b3667793081acc7a"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "47fcd2a50cade4a4abd55adf5ccad572a3815ced"
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-WriteBridge"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-WriteBridge ${D}${bindir}
}
