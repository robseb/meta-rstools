# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to read the general purpose input line from the FPGA" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0" 
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstools.git;protocol=https"
SRCREV = "d9cab94e6c4c94efa1584e2aeb0c1b0f22758685" 
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-gpiRead"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-gpiRead ${D}${bindir}
}
